package com.tunkbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tunkbook.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    //agregar role esrictor de usuario
    @Insert("INSERT INTO users_roles (user_id, role_id) VALUES (#{id}, #{roleId})")
    void insertUserRole(Integer userId, Integer roleId);
}
