package com.recruit.recruitment.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class User {
  private Integer userid;

  private String mail;

  private String password;

  private String username;

  @JsonIgnore
  private List<Role> roles;

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail == null ? null : mail.trim();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password == null ? null : password.trim();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username == null ? null : username.trim();
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }
}