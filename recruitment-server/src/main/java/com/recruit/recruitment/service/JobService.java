package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Job;

import java.util.List;

public interface JobService {
  void addJob(Job job);

  void deleteJobByUserid();

  Job findJobByJobid(Integer jobid);

  List<Job> findJobByUserid();
}
