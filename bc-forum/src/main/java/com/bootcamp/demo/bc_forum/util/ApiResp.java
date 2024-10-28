package com.bootcamp.demo.bc_forum.util;

public class ApiResp<T> {
  private String code;
  private String message;
  private T data;

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  private ApiResp(Builder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static class Builder<T> {
    private String code;
    private String message;
    private T data;

    public Builder<T> ok() {
      this.code = SysCode.OK.getCode();
      this.message = SysCode.OK.getMessage();
      return this;
    }

    public Builder<T> fail(Exception e) {
      this.code = SysCode.FAIL.getCode();
      this.message = e.getMessage();
      return this;
    }

    public Builder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResp<T> build() {
      if (this.data == null)
        throw new IllegalArgumentException("ApiResp.data should not be null.");
      return new ApiResp<>(this);
    }
  }
    // Controller Layer -> return ApiResp<>
    // Global Exception Handler -> return ApiResp<>

    // enum SysCode for Api Response use.
    // enum ErrorCode for error only.


  
}
