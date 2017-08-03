package com.busyzero.easyoj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 关于课程内容不存在时候抛出的异常，来让外部进行处理
 * @author katey2658
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "course  is not found")
public class CourseNotFoundException extends RuntimeException {
}
