package com.recruit.recruitment.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Job {
  private Integer jobid;

  private Integer userid;

  private String companyname;

  private String jobname;

  @DateTimeFormat(pattern = "yyyy-mm-dd")
  private Date jobstart;

  @DateTimeFormat(pattern = "yyyy-mm-dd")
  private Date jobend;

  private String jobdescript;

  public Integer getJobid() {
    return jobid;
  }

  public void setJobid(Integer jobid) {
    this.jobid = jobid;
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
    return jobname;
  }

  public void setJobtitle(String jobtitle) {
    this.jobname = jobtitle == null ? null : jobtitle.trim();
  }

  @JsonFormat(pattern = "yyyy-MM-dd")
  public Date getJobstart() {
    return jobstart;
  }

  public void setJobstart(Date jobstart) {
    this.jobstart = jobstart;
  }

  @JsonFormat(pattern = "yyyy-MM-dd")
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