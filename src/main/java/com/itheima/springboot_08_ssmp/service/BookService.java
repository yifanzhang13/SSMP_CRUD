package com.itheima.springboot_08_ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.springboot_08_ssmp.domain.Book;

import java.util.List;

public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int current, int pageSize);
}
