package com.tunkbook.service.impl;


import com.tunkbook.mapper.CategoryMapper;
import com.tunkbook.pojo.Categories;
import com.tunkbook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    //mapper
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Categories> listCategories() {
        return categoryMapper.list();
    }
}
