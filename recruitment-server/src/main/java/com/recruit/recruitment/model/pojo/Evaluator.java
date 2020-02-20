package com.recruit.recruitment.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Evaluator {
  private Integer evaluatorid;

  private Integer postid;

  private String evaluatorname;

  public Integer getEvaluatorid() {
    return evaluatorid;
  }

  public void setEvaluatorid(Integer evaluatorid) {
    this.evaluatorid = evaluatorid;
  }

  public Integer getPostid() {
    return postid;
  }

  public void setPostid(Integer postid) {
    this.postid = postid;
  }

  public String getEvaluatorname() {
    return evaluatorname;
  }

  public void setEvaluatorname(String evaluatorname) {
    this.evaluatorname = evaluatorname == null ? null : evaluatorname.trim();
  }
}