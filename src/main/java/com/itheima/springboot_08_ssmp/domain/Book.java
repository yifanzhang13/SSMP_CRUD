package com.itheima.springboot_08_ssmp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 自动填写get/set，tostring，hashcode，equals方法，但是没有构造器方法
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
