package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Experience;

import java.util.List;

public interface ExperienceService {
  int addExperience(Experience exp);

  int deleteExperience(Integer expid);

  int updateExperience(Experience exp);

  Experience findExperience(Integer expid);

  List<Experience> findAllExperiences();
}
