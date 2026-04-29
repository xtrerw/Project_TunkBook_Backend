package com.tunkbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tunkbook.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Books> {

    List<Books> listBooks(@Param("id") Integer id);
}
