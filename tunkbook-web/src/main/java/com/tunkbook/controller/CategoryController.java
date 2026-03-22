package com.tunkbook.controller;

import com.tunkbook.pojo.Categories;
import com.tunkbook.pojo.Result;
import com.tunkbook.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CategoryController {
    @Autowired
    private CategoryService cs;

    @GetMapping("/categories")
    public Result list(){
        log.info("muestrar las categorías");

        List<Categories> categoriesList=cs.list();
        return Result.success(categoriesList);
    }

}
