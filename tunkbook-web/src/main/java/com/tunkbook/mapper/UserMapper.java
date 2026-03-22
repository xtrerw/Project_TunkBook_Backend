package com.tunkbook.mapper;


import com.tunkbook.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    //consultar todos los usuarios
    @Select("select * from users")
    List<User> list();
}
