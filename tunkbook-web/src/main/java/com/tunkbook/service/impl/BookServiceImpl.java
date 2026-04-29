package com.tunkbook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tunkbook.mapper.BookMapper;
import com.tunkbook.mapper.RoleMapper;
import com.tunkbook.pojo.Books;
import com.tunkbook.pojo.User;
import com.tunkbook.pojo.UserRoles;
import com.tunkbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Books> listBooks(Integer id) {
        return bookMapper.listBooks(id);
    }

    @Override
    public void addBookToUser(Integer userId, Books book) {
        book.setCreateTime(LocalDate.now());
        book.setUpdateTime(LocalDate.now());
        //
        bookMapper.insert(book);
        //


        //relacionar libro con usuario
        bookMapper.insertBookToUser(book.getId(),userId);
    }
}
