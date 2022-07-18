package com.nmu.training.handler.auth;


import com.alibaba.fastjson.JSON;
import com.nmu.training.common.ResponseResult;
import com.nmu.training.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/10 3:21 下午
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult result=new ResponseResult(HttpStatus.UNAUTHORIZED.value(),"用户认证失败请重新登陆");
        String s = JSON.toJSONString(result);
        WebUtils.renderString(response,s);
    }
}
