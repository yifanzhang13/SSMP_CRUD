package com.itheima.springboot_08_ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.springboot_08_ssmp.dao.BookDao;
import com.itheima.springboot_08_ssmp.domain.Book;
import com.itheima.springboot_08_ssmp.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean saveBook(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public boolean modify(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getPage(int current, int pageSize) {
        IPage page = new Page(current, pageSize);
        bookDao.selectPage(page, null);
        // selectPage()之后page对象会被修改，最后还是返回page对象
        return page;
    }

    @Override
    public IPage<Book> getPage(int current, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        // like的参数：第一个是条件，第二个是对应的属性，第三个是对应的值
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()), Book::getName, book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()), Book::getDescription, book.getDescription());

        IPage page = new Page(current, pageSize);
        bookDao.selectPage(page, lqw);
        // selectPage()之后page对象会被修改，最后还是返回page对象
        return page;
    }
}
