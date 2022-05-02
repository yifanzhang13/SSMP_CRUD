package com.itheima.springboot_08_ssmp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.springboot_08_ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        Book book = bookDao.selectById(1);
        // 开启MP日志之后，就不用打印出来看了，直接看日志
        System.out.println(book);
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }
    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(14);
        book.setType("测试数据abc");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(15);
    }

    @Test
    void testGetAll(){
        bookDao.selectList(null);
    }

    @Test
    void testGetPage(){
        // 得到第2页的5条数据
        IPage page = new Page(2,5);
        bookDao.selectPage(page, null);
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        // select * from tbl_book where name like %Spring%
        qw.like("name","Spring");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        String name = "Spring";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        // select * from tbl_book where name like %Spring%
        lqw.like(name!=null, Book::getName, "Spring");
        bookDao.selectList(lqw);
    }
}
