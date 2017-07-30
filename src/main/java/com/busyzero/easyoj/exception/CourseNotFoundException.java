package com.busyzero.easyoj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "course  is not found")
public class CourseNotFoundException extends RuntimeException {
}
