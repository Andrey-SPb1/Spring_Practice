package org.andrey.spring.http.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "org.andrey.spring.http.rest")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
}
