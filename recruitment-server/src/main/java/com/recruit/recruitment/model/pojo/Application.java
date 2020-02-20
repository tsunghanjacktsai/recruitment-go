package com.recruit.recruitment.model.pojo;

import java.math.BigDecimal;

public class Application {
  private Integer applicationid;

  private Integer resumeid;

  private Integer postid;

  private BigDecimal scoreavg;

  private String applicant;

  private Integer picknum;

  private String jobname;

  private String location;

  private String category;

  public Integer getApplicationid() {
    return applicationid;
  }

  public void setApplicationid(Integer applicationid) {
    this.applicationid = applicationid;
  }

  public Integer getResumeid() {
    return resumeid;
  }

  public void setResumeid(Integer resumeid) {
    this.resumeid = resumeid;
  }

  public Integer getPostid() {
    return postid;
  }

  public void setPostid(Integer postid) {
    this.postid = postid;
  }

  public BigDecimal getScoreavg() {
    return scoreavg;
  }

  public void setScoreavg(BigDecimal scoreavg) {
    this.scoreavg = scoreavg;
  }

  public String getApplicant() {
    return applicant;
  }

  public void setApplicant(String applicant) {
    this.applicant = applicant;
  }

  public Integer getPicknum() {
    return picknum;
  }

  public void setPicknum(Integer picknum) {
    this.picknum = picknum;
  }

  public String getJobname() {
    return jobname;
  }

  public void setJobname(String jobname) {
    this.jobname = jobname;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }
}