package com.tunkbook.service.impl;

import com.tunkbook.mapper.BookMapper;
import com.tunkbook.pojo.Books;
import com.tunkbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Books> listBooks(Integer id) {
        return bookMapper.listBooks(id);
    }
}
