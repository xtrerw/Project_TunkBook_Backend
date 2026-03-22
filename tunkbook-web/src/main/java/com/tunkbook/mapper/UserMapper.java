package com.tunkbook.mapper;


import com.tunkbook.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    //consultar todos los usuarios
    @Select("select * from users")
    List<User> list();

    @Insert("insert into users(username,password,last_name,first_name,email,phone,is_active,create_time,update_time) values(#{username},#{password},#{lastName},#{firstName},#{email},#{phone},#{isActive},#{createTime},#{updateTime})")
    void insert(User user);

    /**
     * verificar los usuarios
     *
     * @param user
     * @return
     */
    @Select("select users.id, users.username, users.password from users inner join reader on users.id=reader.id_user where users.username=#{username} and users.password=#{password}")
    User getByReaderUsernameAndPassword(User user);

    @Select("select users.id, users.username, users.password from users inner join admin on users.id=admin.id_user where users.username=#{username} and users.password=#{password}")
    User getByAdminUsernameAndPassword(User user);

    @Select("select users.id, users.username, users.password from users inner join writer on users.id=writer.id_user where users.username= #{username} and users.password= #{password}")
    User getByWriterUsernameAndPassword(User user);
}
