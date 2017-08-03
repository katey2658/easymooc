package com.busyzero.easyoj.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理类,来处理关于整体web应用中的通用的问题进行处理
 * @author 11456
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 所请求的资源不存在的时候显示的页面
     * @param ex
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noHandlerFound(NoHandlerFoundException ex){
        return "error/error-404";
    }

    /**
     * 服务内部错误的时候显示的页面
     * @param ex
     * @return
     */
    @ExceptionHandler(value = HttpServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String serverInnerErrorHandler(HttpServerErrorException ex){
        return "error/error-server";
    }
}
