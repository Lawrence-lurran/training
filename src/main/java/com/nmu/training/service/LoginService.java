package com.nmu.training.service;


import com.nmu.training.common.ResponseResult;
import com.nmu.training.domain.model.LoginBody;

import java.util.Map;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/8 3:36 下午
 */

public interface LoginService {
    ResponseResult<Map<String ,String >> login(LoginBody user);


    ResponseResult<Boolean> logout();

    ResponseResult<Map<String, String>> register(LoginBody user);
}
