package com.nmu.training.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nmu.training.domain.entity.RoleDO;
import com.nmu.training.mapper.RoleMapper;
import com.nmu.training.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * 角色表(Role)表服务实现类
 *
 * @author makejava
 * @since 2022-07-22 17:02:15
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleDO> implements IRoleService {

}
