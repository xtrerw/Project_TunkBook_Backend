package com.tunkbook.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tunkbook.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LoginMapper extends BaseMapper<User> {
}
