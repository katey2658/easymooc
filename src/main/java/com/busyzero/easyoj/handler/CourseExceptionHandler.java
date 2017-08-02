package com.busyzero.easyoj.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 关于课程模块的全局异常处理类
 * @author 11456
 */
@ControllerAdvice
public class CourseExceptionHandler {
    /**
     * 所请求的内容不存在的时候显示的页面
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String courseNotFoundHandler(NoHandlerFoundException ex){
        return "error/error-404";
    }
}
