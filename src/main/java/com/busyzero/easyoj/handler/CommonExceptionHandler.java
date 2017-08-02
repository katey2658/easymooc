package com.busyzero.easyoj.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class CommonExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String courseNotFoundHandler(){
        return "error/error-404";
    }
}
