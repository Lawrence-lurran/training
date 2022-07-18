package com.nmu.training.service;


import com.nmu.training.common.ResponseResult;
import com.nmu.training.entity.User;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/8 3:36 下午
 */

public interface LoginService {
    ResponseResult login(User user);


    ResponseResult logout();
}
