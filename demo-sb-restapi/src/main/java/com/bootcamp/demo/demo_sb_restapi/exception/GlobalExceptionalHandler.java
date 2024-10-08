package com.bootcamp.demo.demo_sb_restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

@RestControllerAdvice
public class GlobalExceptionalHandler {
  
  // Spring web layer A -> B -> C -> Exception handler -> B
  @ExceptionHandler({RestClientException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400 http status code
  public String restClientExceptionHandler(){
    return "Service Unavailable. Please try again later.";
  }

  @ExceptionHandler({JPHRestClientException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public String JPHRestClientExceptionHandler(){
    return "Json Placeholder Service Unavailable. Please try again later.";
  }
}
