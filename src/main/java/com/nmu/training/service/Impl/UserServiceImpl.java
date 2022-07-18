package com.nmu.training.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.nmu.training.entity.User;
import com.nmu.training.mapper.UserMapper;
import com.nmu.training.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2022-04-08 14:54:30
 */
@Service("sysUserService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}


