package com.tunkbook.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tunkbook.pojo.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper extends BaseMapper<User> {
    //agregar role esrictor de usuario
    @Insert("INSERT INTO user_role (user_id, role_id) VALUES (#{id}, #{roleId})")
    void insertUserRole(Integer id, Integer roleId);
}
