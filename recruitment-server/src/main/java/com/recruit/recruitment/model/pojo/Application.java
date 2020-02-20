package com.recruit.recruitment.model.pojo;

public class Application {
  private Integer applicationid;

  private Integer userid;

  private Integer postid;

  private Boolean status;

  public Integer getApplicationid() {
    return applicationid;
  }

  public void setApplicationid(Integer applicationid) {
    this.applicationid = applicationid;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public Integer getPostid() {
    return postid;
  }

  public void setPostid(Integer postid) {
    this.postid = postid;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}