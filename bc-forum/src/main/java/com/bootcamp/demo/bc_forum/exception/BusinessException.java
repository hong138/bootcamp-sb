package com.bootcamp.demo.bc_forum.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException{
  private int code;

  public static BusinessException of(ErrorCode errorCode) {
    return new BusinessException(errorCode);
  }

  public static BusinessException of(ErrorCode errorCode, String overrideMessage) {
    return new BusinessException(errorCode, overrideMessage);
  }

  private BusinessException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.code = errorCode.getCode();
  }

  private BusinessException(ErrorCode error, String overrideMessage) {
    super(overrideMessage);
    this.code = error.getCode();
  }
}
