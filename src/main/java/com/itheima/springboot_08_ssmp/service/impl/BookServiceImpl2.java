package com.itheima.springboot_08_ssmp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.springboot_08_ssmp.dao.BookDao;
import com.itheima.springboot_08_ssmp.domain.Book;
import com.itheima.springboot_08_ssmp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 定义成业务层的bean
@Service
public class BookServiceImpl2 implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Boolean save(Book book) {
        // bookDao.insert(book)返回的是操作的行数，如果行数大于0说明操作成功
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int current, int pageSize) {
        IPage page = new Page(current, pageSize);
        bookDao.selectPage(page, null);
        // selectPage()之后page对象会被修改，最后还是返回page对象
        return page;
    }
}
