package com.recruit.recruitment.controller;

import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ErrorController {
  public static final String FREQUENT_OPERATION = "/frequent-operation";

  @Autowired
  private HttpServletResponse response;

  /**
   * There is a matched path, but resources not found under such path
   *
   * @return
   */
  @RequestMapping("/not-found")
  public Result notfound() {
    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    return Result.create(StatusCode.NOT_FOUND, "File not found");
  }

  @RequestMapping(FREQUENT_OPERATION)
  public Result frequentOperation() {
    return Result.create(StatusCode.REP_ERROR, "Operation is too frequent");
  }
}
