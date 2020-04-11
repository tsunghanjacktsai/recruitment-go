package com.recruit.recruitment.controller;

import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.entity.StatusCode;
import com.recruit.recruitment.service.EvaluatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluator")
public class EvaluatorController {
  @Autowired
  EvaluatorService evaluatorService;

  @GetMapping("/get-evaluators-by-postid/{postid}")
  public Result getEvaluatorsByPostid(@PathVariable Integer postid) {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        evaluatorService.findEvaluatorsByPostidWithoutUser(postid));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }
}
