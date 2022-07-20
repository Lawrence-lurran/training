package com.nmu.training.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import com.nmu.training.auth.MyUserDetails;
import com.nmu.training.domain.entity.User;
import com.nmu.training.handler.exception.MyRuntimeException;
import com.nmu.training.mapper.MenuMapper;
import com.nmu.training.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;


/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/7 12:22 下午
 */
@Slf4j
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("输入的用户名为:{}",username);
        MyUserDetails myUserDetails = new MyUserDetails();
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername,username));
        if (Objects.isNull(user)) {
            throw new MyRuntimeException("用户名不存在!");
        }
        myUserDetails.setUser(user);
        List<String> list = menuMapper.selectPermsByUserId(user.getId());
        myUserDetails.setPermissions(list);
        return myUserDetails;
    }

}
