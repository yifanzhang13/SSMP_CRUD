package com.itheima.springboot_08_ssmp.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 作为SpringMVC的异常处理
// 这里处理的是controller（表现层）的异常，数据层和业务层的异常最后也会在表现层抛出，所以只需要处理表现层的异常
@RestControllerAdvice
public class ProjectExceptionAdvice {

    // 拦截所有的异常信息（如果想拦截某个异常，可以在value中写上对应的class）
    @ExceptionHandler(Exception.class)
    public R doException(Exception ex){
        // 记录日志，通知运维，通知开发
        ex.printStackTrace();
        return new R("服务器鼓掌，请稍后再试！");
    }

}
