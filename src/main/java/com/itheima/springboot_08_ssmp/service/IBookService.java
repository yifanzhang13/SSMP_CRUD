package com.itheima.springboot_08_ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.springboot_08_ssmp.domain.Book;

public interface IBookService extends IService<Book> {
    // MP提供的可以直接用，不能用的就自己写，如果重名，就写@Override注解
    boolean saveBook(Book book);

    boolean modify(Book book);

    boolean delete(Integer id);

    IPage<Book> getPage(int current, int pageSize);

    IPage<Book> getPage(int current, int pageSize, Book book);
}
