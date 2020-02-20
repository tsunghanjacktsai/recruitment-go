package com.recruit.recruitment.model.entity;

/**
 * Status code
 */
public class StatusCode {
  /**
   * Operation successful
   */
  public static final int SUCCESS = 200;

  /**
   * Operation failed
   */
  public static final int ERROR = 201;

  /**
   * Username or password incorrect
   */
  public static final int LOGIN_ERROR = 202;

  /**
   * Token expired
   */
  public static final int TOKEN_EXPIRE = 203;

  /**
   * Access denied
   */
  public static final int ACCESS_ERROR = 403;

  /**
   * Remote operation failed
   */
  public static final int REMOTE_ERROR = 204;

  /**
   * Operation repeated
   */
  public static final int REP_ERROR = 205;

  /**
   * Service error
   */
  public static final int SERVICE_ERROR = 500;

  /**
   * Resources not exist
   */
  public static final int NOT_FOUND = 404;
}
