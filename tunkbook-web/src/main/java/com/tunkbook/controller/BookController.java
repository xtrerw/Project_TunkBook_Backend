package com.tunkbook.controller;

import com.tunkbook.pojo.Books;
import com.tunkbook.pojo.Result;
import com.tunkbook.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/categories/{categoriaName}/{subcategoriaName}")
    public Result listBooks(@PathVariable String categoriaName, @PathVariable String subcategoriaName){
        log.info("muestra todos los libros según categoryName={} y subcategoriaName={}",categoriaName, subcategoriaName);

        List<Books> booksList=bookService.listBooks(categoriaName, subcategoriaName);
        return Result.success(booksList);
    }

}
