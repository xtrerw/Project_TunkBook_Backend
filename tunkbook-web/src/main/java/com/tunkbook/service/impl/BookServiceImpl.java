package com.tunkbook.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tunkbook.mapper.BookMapper;
import com.tunkbook.mapper.RoleMapper;
import com.tunkbook.pojo.Books;
import com.tunkbook.pojo.User;
import com.tunkbook.pojo.UserRoles;
import com.tunkbook.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Slf4j
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Books> listBooks(String categoriaName, String subcategoriaName) {
        return bookMapper.listBooks(categoriaName, subcategoriaName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addBookToUser(Integer userId, Books book) {

        //verificar si el usuario es escritor
        boolean isWriter = !roleMapper.selectList(
                new LambdaQueryWrapper<UserRoles>()
                        .eq(UserRoles::getUserId, userId)
                        .eq(UserRoles::getRoleId, 2)
        ).isEmpty();

        if (!isWriter){
            log.error("El usuarrio {} no es escritor,primero activa tu cuenta a role escritor",userId);
            throw new RuntimeException("El usuario no tiene permiso de escritor");
        }

        //verificar no existe libro
        if (book.getId()!=null && bookMapper.selectById(book.getId())!=null){
            log.error("El libro {} ya existe",book.getId());
            throw new RuntimeException("El libro ya existe");
        }
        //establecer fecha de creacion y actualizacion
        book.setCreateTime(LocalDate.now());
        book.setUpdateTime(LocalDate.now());
        //
        log.info("Usuario {} agregando libro:{}",userId,book.getBookName());
        //add book
        bookMapper.insert(book);
        //relacionar book con usuario
        bookMapper.insertBookToUser(book.getId(),userId);
    }
}
