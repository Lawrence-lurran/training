package com.nmu.training.controller;



import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nmu.training.auth.MyUserDetails;
import com.nmu.training.common.ResponseResult;
import com.nmu.training.domain.entity.RoleDO;
import com.nmu.training.domain.entity.User;
import com.nmu.training.domain.entity.UserRoleDO;
import com.nmu.training.domain.model.LoginBody;
import com.nmu.training.mapper.MenuMapper;
import com.nmu.training.service.IRoleService;
import com.nmu.training.service.IUserRoleService;
import com.nmu.training.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/8 3:33 下午
 */
@Api(value = "登录 注册 退出", tags="{登录 注册 退出 接口}")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;


    @ApiOperation(value = "登录")
    @PostMapping("/user/login")
    public ResponseResult<Map<String ,String >> login(@RequestBody LoginBody user){
        return loginService.login(user);
    }
    @ApiOperation(value = "登出")
    @GetMapping ("/user/logout")
    public ResponseResult<Boolean> logout(){
        return loginService.logout();
    }

    @PostMapping("/user/register")
    @ApiOperation(value = "注册")
    public ResponseResult<Map<String ,String >> register(@RequestBody LoginBody user){
        return loginService.register(user);
    }
    @GetMapping("/user/getInfo")
    public ResponseResult<Map<String ,Object >> getInfo() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails loginUser = (MyUserDetails) authenticationToken.getPrincipal();
        Map<String, Object> data = new HashMap<>();
        data.put("user",loginUser.getUser());
        data.put("roles",loginUser.getRoles());
        data.put("permissions",loginUser.getPermissions());
        return ResponseResult.success(data);
    }

}
