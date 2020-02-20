package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.model.pojo.Application;
import com.recruit.recruitment.mapper.ApplicationMapper;
import com.recruit.recruitment.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "applicationService")
public class ApplicationServiceImpl implements ApplicationService {
  @Autowired
  private ApplicationMapper applicationMapper;

  @Override
  public int addApplication(Application application) {
    return applicationMapper.insertSelective(application);
  }

  @Override
  public int deleteApplication(Integer applicationid) {
    return applicationMapper.deleteByPrimaryKey(applicationid);
  }

  @Override
  public int updateApplication(Application application) {
    return applicationMapper.updateByPrimaryKeySelective(application);
  }

  @Override
  public Application findApplication(Integer applicationid) {
    return applicationMapper.selectByPrimaryKey(applicationid);
  }
}
