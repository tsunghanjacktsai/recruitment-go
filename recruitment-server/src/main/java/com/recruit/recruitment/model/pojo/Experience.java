package com.recruit.recruitment.model.pojo;

import java.util.Date;

public class Experience {
  private Integer expid;

  private Integer userid;

  private String companyname;

  private String jobtitle;

  private Date jobstart;

  private Date jobend;

  private String jobdescript;

  public Integer getExpid() {
    return expid;
  }

  public void setExpid(Integer expid) {
    this.expid = expid;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname == null ? null : companyname.trim();
  }

  public String getJobtitle() {
    return jobtitle;
  }

  public void setJobtitle(String jobtitle) {
    this.jobtitle = jobtitle == null ? null : jobtitle.trim();
  }

  public Date getJobstart() {
    return jobstart;
  }

  public void setJobstart(Date jobstart) {
    this.jobstart = jobstart;
  }

  public Date getJobend() {
    return jobend;
  }

  public void setJobend(Date jobend) {
    this.jobend = jobend;
  }

  public String getJobdescript() {
    return jobdescript;
  }

  public void setJobdescript(String jobdescript) {
    this.jobdescript = jobdescript == null ? null : jobdescript.trim();
  }
}