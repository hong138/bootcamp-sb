package com.bootcamp.bc_calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


public class GlobalExceptionHandler {

  @ExceptionHandler(CannotDivideZeroException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  ErrorResponse cannotDivideZeroException() {
    return new ErrorResponse.builder()
    .code(1)
    .message("")
    .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  ErrorResponse cannotDivideZeroException() {
    return new ErrorResponse.builder()
    .code(1)
    .message("")
    .build();
  }
}
