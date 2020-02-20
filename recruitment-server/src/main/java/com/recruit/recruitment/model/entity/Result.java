package com.recruit.recruitment.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Response entity
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
  // Response code
  private Integer code;

  // Response message
  private String message;

  // Response data
  private Object data;

  private Result() {
  }

  private Result(Integer code, String message) {
    super();
    this.code = code;
    this.message = message;
  }

  private Result(Integer code, String message, Object data) {
    super();
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public static Result create(Integer code, String message) {
    return new Result(code, message);
  }

  public static Result create(Integer code, String message, Object data) {
    return new Result(code, message, data);
  }
}
