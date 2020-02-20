package com.recruit.recruitment.model.pojo;

import java.util.Date;

public class Post {
  private Integer postid;

  private Integer authorid;

  private String companyname;

  private String jobname;

  private String location;

  private String category;

  private Integer salary;

  private Integer salarytype;

  private String description;

  private String criteria;

  private Date due;

  private Integer picknum;

  public Integer getPostid() {
    return postid;
  }

  public void setPostid(Integer postid) {
    this.postid = postid;
  }

  public Integer getAuthorid() {
    return authorid;
  }

  public void setAuthorid(Integer authorid) {
    this.authorid = authorid;
  }

  public String getCompanyname() {
    return companyname;
  }

  public void setCompanyname(String companyname) {
    this.companyname = companyname == null ? null : companyname.trim();
  }

  public String getJobname() {
    return jobname;
  }

  public void setJobname(String jobname) {
    this.jobname = jobname == null ? null : jobname.trim();
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location == null ? null : location.trim();
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category == null ? null : category.trim();
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  public Integer getSalarytype() {
    return salarytype;
  }

  public void setSalarytype(Integer salarytype) {
    this.salarytype = salarytype;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description == null ? null : description.trim();
  }

  public String getCriteria() {
    return criteria;
  }

  public void setCriteria(String criteria) {
    this.criteria = criteria == null ? null : criteria.trim();
  }

  public Date getDue() {
    return due;
  }

  public void setDue(Date due) {
    this.due = due;
  }

  public Integer getPicknum() {
    return picknum;
  }

  public void setPicknum(Integer picknum) {
    this.picknum = picknum;
  }
}