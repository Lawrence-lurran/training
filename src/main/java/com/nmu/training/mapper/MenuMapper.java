package com.nmu.training.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nmu.training.domain.entity.Menu;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * Description:
 *
 * @author lurran
 * @data Created on 2022/4/10 1:47 下午
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<String > selectPermsByUserId(Long userid);
}
