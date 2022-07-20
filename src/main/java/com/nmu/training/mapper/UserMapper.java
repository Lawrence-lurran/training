package com.nmu.training.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nmu.training.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(User)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-08 14:54:27
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}


