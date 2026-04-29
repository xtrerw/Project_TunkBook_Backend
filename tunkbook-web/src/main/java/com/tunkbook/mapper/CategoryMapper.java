package com.tunkbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tunkbook.pojo.Categories;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper extends BaseMapper<Categories> {
    List<Categories> list();
}
