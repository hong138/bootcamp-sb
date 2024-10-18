package com.bootcamp.demo.bc_forum.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  USER_NOT_FOUND_EX(1, "User not found."), //
  INV_INPUT_EX(2, "Invalid Input."), //
  REST_CLIENT_EX(3, "Rest Client Exception."),;

  private int code;
  private String message;

  private ErrorCode(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
