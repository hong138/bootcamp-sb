package com.bootcamp.demo.bc_forum.util;

public enum SysCode {
  OK("000000", "Success."), 
  FAIL("900000", "Fail."), 
  EXCEPTION("999999", "Unhandled Exception."), 
  ;

  private String code;
  private String message;

  private SysCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }
}
