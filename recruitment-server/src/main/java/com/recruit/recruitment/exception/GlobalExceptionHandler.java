package com.recruit.recruitment.exception;

import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.entity.StatusCode;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Exception handle
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(NoHandlerFoundException.class)
  public Result noHandlerFoundExceptionHandler(Exception e) {
    return Result.create(StatusCode.NOT_FOUND, "No handler found");
  }

  @ExceptionHandler(AccessDeniedException.class)
  public Result accessDeniedExceptionHandler(Exception e) {
    return Result.create(StatusCode.ACCESS_ERROR, "Access denied");
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public Result httpRequestMethodNotSupportedExceptionHandler(Exception e) {
    return Result.create(StatusCode.ERROR, "Request method error");
  }

  @ExceptionHandler({
    MissingServletRequestParameterException.class,
    MethodArgumentTypeMismatchException.class,
    RequestRejectedException.class}
  )
  public Result missingServletRequestParameterException(Exception e) {
    return Result.create(StatusCode.ERROR, "Parameter exception");
  }

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public Result maxUploadSizeExceededException(Exception e) {
    return Result.create(StatusCode.ERROR, "Exceed max upload size");
  }

  @ExceptionHandler(ClientAbortException.class)
  public Result clientAbortExceptionException(Exception e) {
    return Result.create(StatusCode.ERROR, "Client error");
  }

  @ExceptionHandler(Exception.class)
  public Result exceptionHander(Exception e) {
    e.printStackTrace();
    return Result.create(StatusCode.SERVICE_ERROR, "Service error");
  }
}
