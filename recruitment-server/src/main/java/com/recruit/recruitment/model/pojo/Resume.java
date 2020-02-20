package com.recruit.recruitment.model.pojo;

import java.util.Date;

public class Resume {
  private Integer resumeid;

  private Integer userid;

  private String name;

  private Integer age;

  private String phone;

  private String location;

  private String intention;

  private String website;

  private String statement;

  private String degree;

  private String major;

  private String school;

  private Date edustart;

  private Date eduend;

  private String edudescript;

  private String score;

  public Integer getResumeid() {
    return resumeid;
  }

  public void setResumeid(Integer resumeid) {
    this.resumeid = resumeid;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone == null ? null : phone.trim();
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location == null ? null : location.trim();
  }

  public String getIntention() {
    return intention;
  }

  public void setIntention(String intention) {
    this.intention = intention == null ? null : intention.trim();
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website == null ? null : website.trim();
  }

  public String getStatement() {
    return statement;
  }

  public void setStatement(String statement) {
    this.statement = statement == null ? null : statement.trim();
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree == null ? null : degree.trim();
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major == null ? null : major.trim();
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school == null ? null : school.trim();
  }

  public Date getEdustart() {
    return edustart;
  }

  public void setEdustart(Date edustart) {
    this.edustart = edustart;
  }

  public Date getEduend() {
    return eduend;
  }

  public void setEduend(Date eduend) {
    this.eduend = eduend;
  }

  public String getEdudescript() {
    return edudescript;
  }

  public void setEdudescript(String edudescript) {
    this.edudescript = edudescript == null ? null : edudescript.trim();
  }

  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score == null ? null : score.trim();
  }
}