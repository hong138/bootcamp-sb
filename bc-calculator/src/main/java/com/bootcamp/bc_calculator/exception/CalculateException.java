package com.bootcamp.bc_calculator.exception;

import lombok.Getter;

@Getter
public class CalculateException extends IllegalArgumentException{
  private String message;

  public CalculateException(String message) {
    this.message = message;
  }
}
