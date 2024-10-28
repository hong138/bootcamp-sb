package com.bootcamp.demo.bc_forum.util;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class GlobalExceptionalHandler {
  
  @ExceptionHandler({BusinessException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Object> businessExceptionHandler(BusinessException e) {
    System.out.println("error message=" + e.getMessage());
    return ApiResp.<Object>builder()
        .fail(e) 
        .data(new ArrayList<>()) 
        .build();
  }

  @ExceptionHandler({Exception.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ApiResp<Object> unhandledExceptionHandler(Exception e) {
    System.out.println("error message=" + e.getMessage());
    return ApiResp.<Object>builder()
        .fail(e) 
        .data(new ArrayList<>())
        .build();
  }
}
