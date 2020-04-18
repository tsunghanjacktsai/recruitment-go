package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Job;

import java.util.List;

public interface JobService {
  void addJobExp(Job job);

  void deleteJobExpByUserid();

  Job findJobExpByJobid(Integer jobid);

  List<Job> findJobExpByUserid();
}
