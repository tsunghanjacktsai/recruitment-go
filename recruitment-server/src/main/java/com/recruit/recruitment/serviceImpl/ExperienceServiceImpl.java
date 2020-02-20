package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.model.pojo.Experience;
import com.recruit.recruitment.mapper.ExperienceMapper;
import com.recruit.recruitment.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "experienceService")
public class ExperienceServiceImpl implements ExperienceService {
  @Autowired
  private ExperienceMapper experienceMapper;

  @Override
  public int addExperience(Experience exp) {
    return experienceMapper.insertSelective(exp);
  }

  @Override
  public int deleteExperience(Integer expid) {
    return experienceMapper.deleteByPrimaryKey(expid);
  }

  @Override
  public int updateExperience(Experience exp) {
    return experienceMapper.updateByPrimaryKeySelective(exp);
  }

  @Override
  public Experience findExperience(Integer expid) {
    return experienceMapper.selectByPrimaryKey(expid);
  }

  @Override
  public List<Experience> findAllExperiences() {
    return experienceMapper.selectAll();
  }
}
