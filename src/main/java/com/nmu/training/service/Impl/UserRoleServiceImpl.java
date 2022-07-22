package com.nmu.training.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nmu.training.domain.entity.UserRoleDO;
import com.nmu.training.mapper.UserRoleMapper;
import com.nmu.training.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * (UserRole)表服务实现类
 *
 * @author makejava
 * @since 2022-07-22 16:18:53
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleDO> implements IUserRoleService {

}
