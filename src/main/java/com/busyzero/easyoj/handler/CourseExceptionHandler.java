package com.busyzero.easyoj.handler;

import com.busyzero.easyoj.exception.CourseNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 关于课程模块的异常处理类
 * @author 11456
 */
@ControllerAdvice
public class CourseExceptionHandler {
    /**
     * 所请求的内容不存在的时候显示的页面
     * @return
     */
    @ExceptionHandler(CourseNotFoundException.class)
    public String courseNotFoundHandler(){
        return "error/courseNotFound";
    }
}
