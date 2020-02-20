package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Skill;

import java.util.List;

public interface SkillService {
  int addSkill(Skill skill);

  int deleteSkill(Integer skillid);

  Skill findSkill(Integer skillid);

  List<Skill> findAllSkills();
}
