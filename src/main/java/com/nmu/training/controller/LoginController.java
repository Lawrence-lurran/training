package com.nmu.training.controller;




import com.nmu.training.annotation.Log;
import com.nmu.training.auth.MyUserDetails;
import com.nmu.training.common.ResponseResult;
import com.nmu.training.domain.model.LoginBody;
import com.nmu.training.enums.BusinessType;
import com.nmu.training.enums.OperatorType;
import com.nmu.training.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.Map;

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
    @Log(title = "登录",operatorType = OperatorType.MOBILE,isAuthentication = false)
    @PostMapping("/user/login")
    public ResponseResult<Map<String ,String >> login(@RequestBody LoginBody user){
        return loginService.login(user);
    }
    @ApiOperation(value = "登出")
    @GetMapping ("/user/logout")
    @Log(title = "登出",operatorType = OperatorType.MOBILE)
    public ResponseResult<Boolean> logout(){
        return loginService.logout();
    }

    @PostMapping("/user/register")
    @ApiOperation(value = "注册")
    @Log(title = "注册",businessType = BusinessType.INSERT,operatorType = OperatorType.MOBILE,isAuthentication = false)
    public ResponseResult<Map<String ,String >> register(@RequestBody LoginBody user){
        return loginService.register(user);
    }
    @GetMapping("/user/getInfo")
    @Log(title = "获取用户信息",businessType = BusinessType.QUERY,operatorType = OperatorType.MOBILE)
    @ApiOperation(value = "获取用户信息")
    public ResponseResult<Map<String ,Object >> getInfo() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails loginUser = (MyUserDetails) authenticationToken.getPrincipal();
        Map<String, Object> data = new HashMap<>();
        data.put("user",loginUser.getUserDO());
        data.put("roles",loginUser.getRoles());
        data.put("permissions",loginUser.getPermissions());
        return ResponseResult.success(data);
    }

}
