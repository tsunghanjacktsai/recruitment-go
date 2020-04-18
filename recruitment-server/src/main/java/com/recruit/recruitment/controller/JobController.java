package com.recruit.recruitment.controller;

import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.entity.StatusCode;
import com.recruit.recruitment.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {
  @Autowired
  private JobService jobService;

  @GetMapping("/get-job")
  public Result findJobByUserId() {
    return Result.create(StatusCode.SUCCESS, "Query successful", jobService.findJobExpByUserid());
  }
}
