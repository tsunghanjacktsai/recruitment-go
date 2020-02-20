package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Application;

public interface ApplicationService {
  int addApplication(Application application);

  int deleteApplication(Integer applicationid);

  int updateApplication(Application application);

  Application findApplication(Integer applicationid);
}
