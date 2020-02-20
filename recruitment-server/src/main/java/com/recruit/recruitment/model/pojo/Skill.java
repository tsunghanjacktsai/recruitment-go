package com.recruit.recruitment.model.pojo;

public class Skill {
  private Integer skillid;

  private Integer userid;

  private String skillname;

  private Integer skillprof;

  public Integer getSkillid() {
    return skillid;
  }

  public void setSkillid(Integer skillid) {
    this.skillid = skillid;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getSkillname() {
    return skillname;
  }

  public void setSkillname(String skillname) {
    this.skillname = skillname == null ? null : skillname.trim();
  }

  public Integer getSkillprof() {
    return skillprof;
  }

  public void setSkillprof(Integer skillprof) {
    this.skillprof = skillprof;
  }
}