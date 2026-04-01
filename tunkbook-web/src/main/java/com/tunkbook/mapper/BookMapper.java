package com.tunkbook.mapper;

import com.tunkbook.pojo.Books;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Books> listBooks(Integer id);
}
