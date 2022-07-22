package com.nmu.training.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nmu.training.domain.entity.UserRoleDO;
import org.apache.ibatis.annotations.Mapper;


/**
 * (UserRole)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-22 16:18:52
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoleDO> {

}

