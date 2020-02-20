package com.recruit.recruitment.controller;

import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.entity.StatusCode;
import com.recruit.recruitment.model.pojo.Application;
import com.recruit.recruitment.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/application")
public class ApplicationController {
  @Autowired
  private ApplicationService applicationService;

  @PutMapping("/apply-job/{postid}")
  public Result applyJob(@PathVariable Integer postid) {
    try {
      applicationService.addApplicationToPost(postid);
      return Result.create(StatusCode.SUCCESS, "Apply successful");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Apply failed");
    }
  }

  @GetMapping("/check-if-applied/{postid}")
  public Result checkIfApplied(@PathVariable Integer postid) {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successfu",
        applicationService.checkIfApplied(postid));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }

  @GetMapping("/get-applications-by-user")
  public Result getApplicationsByUser() {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        applicationService.findApplicationsByUser());
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }

  @GetMapping("/get-applications-by-postid/{postid}")
  public Result getApplicationsByPostid(@PathVariable Integer postid) {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        applicationService.findApplicationsByPostid(postid));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }

  @GetMapping("/get-application-by-applicationid/{applicationid}")
  public Result getApplicationByApplicationid(@PathVariable Integer applicationid) {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        applicationService.findApplicationByApplicationid(applicationid));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }

  @DeleteMapping("/delete-application-by-applicationid/{applicationid}")
  public Result deleteApplicationByApplicationid(@PathVariable Integer applicationid) {
    try {
      applicationService.deleteApplication(applicationid);
      return Result.create(StatusCode.SUCCESS, "Delete successful");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Delete failed");
    }
  }

  @PutMapping("/score-application/{applicationid}")
  public Result scoreApplication(@PathVariable Integer applicationid, Integer score) {
    try {
      applicationService.scoreApplication(applicationid, score);
      return Result.create(StatusCode.SUCCESS, "Score candidate successful");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Score candidate failed");
    }
  }
}
