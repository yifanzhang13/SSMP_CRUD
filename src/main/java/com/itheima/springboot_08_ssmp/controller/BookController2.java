package com.itheima.springboot_08_ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.springboot_08_ssmp.domain.Book;
import com.itheima.springboot_08_ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }

    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping
    // @RequestBody注解是因为book参数是用JSON在request body中发送的
    public Boolean update(@RequestBody Book book){
        return bookService.updateById(book);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id){
        return bookService.delete(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }

    // 有误，不能直接传null
    @GetMapping("/{current}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int current, @PathVariable int pageSize){
        return bookService.getPage(current, pageSize, null);
    }
}
