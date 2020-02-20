package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.model.pojo.Skill;
import com.recruit.recruitment.mapper.SkillMapper;
import com.recruit.recruitment.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "skillService")
public class SkillServiceImpl implements SkillService {
  @Autowired
  private SkillMapper skillMapper;

  @Override
  public int addSkill(Skill skill) {
    return skillMapper.insertSelective(skill);
  }

  @Override
  public int deleteSkill(Integer skillid) {
    return skillMapper.deleteByPrimaryKey(skillid);
  }

  @Override
  public Skill findSkill(Integer skillid) {
    return skillMapper.selectByPrimaryKey(skillid);
  }

  @Override
  public List<Skill> findAllSkills() {
    return skillMapper.selectAll();
  }
}
