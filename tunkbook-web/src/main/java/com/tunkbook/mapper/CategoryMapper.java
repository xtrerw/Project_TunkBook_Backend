package com.tunkbook.mapper;

import com.tunkbook.pojo.Categories;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {


    List<Categories> list();
}
