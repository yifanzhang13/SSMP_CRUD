package com.itheima.springboot_08_ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.springboot_08_ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IBookServiceTestCase {

    @Autowired
    private IBookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.save(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(14);
        book.setType("测试数据abc");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.updateById(book);
    }

    @Test
    void testDelete(){
        System.out.println("delete true or false: "+bookService.removeById(15));;
    }

    @Test
    void testGetAll(){
        System.out.println("====testGetAll starts=====");
        System.out.println(bookService.list());;
        System.out.println("====testGetAll ends=====");
    }

    @Test
    void testGetPage(){
        // 得到第2页的5条数据
        IPage<Book> page = new Page<>(2, 5);
        bookService.page(page);
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getRecords());
    }
}
