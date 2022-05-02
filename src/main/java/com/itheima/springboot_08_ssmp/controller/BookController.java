package com.itheima.springboot_08_ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.springboot_08_ssmp.controller.utils.R;
import com.itheima.springboot_08_ssmp.domain.Book;
import com.itheima.springboot_08_ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true, bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if(book.getName().equals("123")) throw new IOException();
        boolean flag = bookService.save(book);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    // @RequestBody注解是因为book参数是用JSON在request body中发送的
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.delete(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, bookService.getById(id));
    }

//    @GetMapping("/{current}/{pageSize}")
//    public R getPage(@PathVariable int current, @PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(current, pageSize);
//        // 如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if (current > page.getPages()){
//            page = bookService.getPage((int) page.getPages(), pageSize);
//        }
//        return new R(true, page);
//    }

    @GetMapping("/{current}/{pageSize}")
    // 传递的参数名为name,type,description，参数名与实体类Book中的属性名一直，SpringMVC自动为实体类注入属性
    public R getPage(@PathVariable int current, @PathVariable int pageSize, Book book){
        IPage<Book> page = bookService.getPage(current, pageSize, book);
        // 如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (current > page.getPages()){
            page = bookService.getPage((int) page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }

}
