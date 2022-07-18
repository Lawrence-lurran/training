package com.nmu.training.service.Impl;


import com.nmu.training.auth.MyUserDetails;
import com.nmu.training.common.ResponseResult;
import com.nmu.training.entity.User;
import com.nmu.training.handler.exception.MyRuntimeException;
import com.nmu.training.service.LoginService;
import com.nmu.training.util.JwtUtil;
import com.nmu.training.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/8 3:36 下午
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private RedisCache redisCache;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)){
            throw new MyRuntimeException("登陆失败");
        }
        MyUserDetails loginUser = (MyUserDetails) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();

        String jwt = JwtUtil.createJWT(userId);
        redisCache.setCacheObject("login:"+userId,loginUser);
        Map<String,String> map=new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"登陆成功",map);
    }

    @Override
    public ResponseResult logout() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails loginUser = (MyUserDetails) authenticationToken.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String redisKey="login:"+userId;
        redisCache.deleteObject(redisKey);
        return new ResponseResult(200,"注销成功");
    }
}
