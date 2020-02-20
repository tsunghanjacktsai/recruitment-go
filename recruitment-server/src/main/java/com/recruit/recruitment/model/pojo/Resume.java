package com.recruit.recruitment.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Resume {
  private Integer resumeid;

  private Integer userid;

  private String username;

  private String mail;

  private String name;

  private String phone;

  private String location;

  private String intention;

  private String website;

  private String statement;

  private String major;

  private String school;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date edustart;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date eduend;

  private String edudescript;

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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
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

  @JsonFormat(pattern = "yyyy-MM-dd")
  public Date getEdustart() {
    return edustart;
  }

  public void setEdustart(Date edustart) {
    this.edustart = edustart;
  }

  @JsonFormat(pattern = "yyyy-MM-dd")
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
}