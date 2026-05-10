package com.tunkbook.service;


import com.tunkbook.pojo.Books;

import java.util.List;

public interface BookService {
    void addBookToUser(Integer userId, Books book);

    List<Books> listBooks(String categoriaName, String subcategoriaName);
}
