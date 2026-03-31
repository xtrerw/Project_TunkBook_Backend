package com.tunkbook.mapper;


import com.tunkbook.pojo.User;
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
     * @param username
     * @return
     */
    @Select("select id,last_name,username,password from users where username=#{username}")
    User getByUsername(String username);

    /**
     * 用户权限可能有多个，所以要用list
     *
     * @param userId
     */
    @Select("select role_name from roles r inner join users_roles ur on r.id=ur.role_id where ur.user_id=#{userId}")
    List<String> getUserRolesById(Integer userId);
}
