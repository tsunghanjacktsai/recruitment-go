package com.recruit.recruitment.model.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "post", type = "article")
public class Post implements Serializable {
  @Id
  private Integer postid;

  private Integer authorid;

  private String companyname;

  private String jobname;

  private String location;

  private String category;

  private Integer salary;

  private String salarytype;

  private String description;

  private String criteria;

  private String due;

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

  public String getSalarytype() {
    return salarytype;
  }

  public void setSalarytype(String salarytype) {
    this.salarytype = salarytype == null ? null : salarytype.trim();
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

  public String getDue() {
    return due;
  }

  public void setDue(String due) {
    this.due = due;
  }

  public Integer getPicknum() {
    return picknum;
  }

  public void setPicknum(Integer picknum) {
    this.picknum = picknum;
  }

  @Override
  public String toString() {
    return "Post{" +
      "postid=" + postid +
      ", authorid=" + authorid +
      ", companyname='" + companyname + '\'' +
      ", jobname='" + jobname + '\'' +
      ", location='" + location + '\'' +
      ", category='" + category + '\'' +
      ", salary=" + salary +
      ", salarytype='" + salarytype + '\'' +
      ", description='" + description + '\'' +
      ", criteria='" + criteria + '\'' +
      ", due=" + due +
      ", picknum=" + picknum +
      '}';
  }
}