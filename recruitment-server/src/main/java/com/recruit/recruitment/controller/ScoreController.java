package com.recruit.recruitment.controller;

import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.entity.StatusCode;
import com.recruit.recruitment.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score")
public class ScoreController {
  @Autowired
  private ScoreService scoreService;

  @GetMapping("/get-application-score-by-marker/{applicationid}")
  public Result getApplicationScoreByMarker(@PathVariable Integer applicationid) {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        scoreService.findApplicationScoreByMarker(applicationid));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Query failed");
    }
  }
}
