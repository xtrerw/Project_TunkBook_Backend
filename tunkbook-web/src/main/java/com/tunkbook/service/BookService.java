package com.tunkbook.service;


import com.tunkbook.pojo.Books;

import java.util.List;

public interface BookService {

    List<Books> listBooks(Integer bookId);

    void addBookToUser(Integer userId, Books book);
}
