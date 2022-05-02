package com.itheima.springboot_08_ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.springboot_08_ssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
