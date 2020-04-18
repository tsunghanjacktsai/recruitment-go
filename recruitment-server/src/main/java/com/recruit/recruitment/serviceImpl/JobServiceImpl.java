package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.mapper.JobMapper;
import com.recruit.recruitment.mapper.UserMapper;
import com.recruit.recruitment.model.pojo.Job;
import com.recruit.recruitment.model.pojo.User;
import com.recruit.recruitment.service.JobService;
import com.recruit.recruitment.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
  @Autowired
  JobMapper jobMapper;

  @Autowired
  UserMapper userMapper;

  @Autowired
  JwtTokenUtil jwtTokenUtil;

  @Autowired
  HttpServletRequest request;

  @Override
  public void addJobExp(Job job) {
    jobMapper.insertSelective(job);
  }

  @Override
  public void deleteJobExpByUserid() {
    String username = jwtTokenUtil.getUsernameFromRequest(request);
    User user = userMapper.selectByUsername(username);
    jobMapper.deleteByUserid(user.getUserid());
  }

  @Override
  public Job findJobExpByJobid(Integer jobid) {
    return jobMapper.selectByPrimaryKey(jobid);
  }

  @Override
  public List<Job> findJobExpByUserid() {
    String username = jwtTokenUtil.getUsernameFromRequest(request);
    User user = userMapper.selectByUsername(username);
    return jobMapper.selectByUserid(user.getUserid());
  }
}
