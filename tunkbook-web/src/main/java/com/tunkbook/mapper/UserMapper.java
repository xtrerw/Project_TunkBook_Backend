package com.tunkbook.mapper;


import com.tunkbook.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {


//    @Insert("insert into users(username,password,last_name,first_name,email,phone,is_active,create_time,update_time) values(#{username},#{password},#{lastName},#{firstName},#{email},#{phone},#{isActive},#{createTime},#{updateTime})")
    void insert(User user);

    /**
     * verificar los usuarios
     *
     * @param user
     * @return
     */
    User getByUserNameAndPassword(User user);
}
