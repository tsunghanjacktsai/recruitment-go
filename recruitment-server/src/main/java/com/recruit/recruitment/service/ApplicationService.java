package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Application;

import java.util.List;

public interface ApplicationService {
  void addApplicationToPost(Integer postid);

  void deleteApplication(Integer applicationid);

  boolean checkIfEvaluators(Integer postid);

  boolean checkIfApplied(Integer postid);

  Application findApplicationByApplicationid(Integer applicationid);

  List<Application> findApplicationsByPostid(Integer postid);

  List<Application> findApplicationsByUser();

  void scoreApplication(Integer applicationid, Integer score);
}
