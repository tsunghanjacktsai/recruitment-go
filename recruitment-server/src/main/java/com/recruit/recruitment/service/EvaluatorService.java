package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Evaluator;

import java.util.List;

public interface EvaluatorService {
  void addEvaluator(Evaluator evaluator);

  List<String> findEvaluatorsByPostidWithoutUser(Integer postid);

  List<String> findEvaluatorsByPostidWithUser(Integer postid);
}
