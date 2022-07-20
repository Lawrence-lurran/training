package com.nmu.training.controller;



import com.nmu.training.common.ResponseResult;
import com.nmu.training.domain.entity.User;
import com.nmu.training.domain.model.LoginBody;
import com.nmu.training.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/8 3:33 下午
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult<Map<String ,String >> login(@RequestBody LoginBody user){
        return loginService.login(user);
    }
    @GetMapping ("/user/logout")
    public ResponseResult<Boolean> logout(){
        return loginService.logout();
    }

    @PostMapping("/user/register")
    public ResponseResult<Map<String ,String >> register(@RequestBody LoginBody user){
        return loginService.register(user);
    }

}
