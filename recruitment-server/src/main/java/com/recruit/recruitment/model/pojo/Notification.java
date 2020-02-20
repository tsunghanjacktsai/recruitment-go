package com.recruit.recruitment.model.pojo;

public class Notification {
  private Integer notificationid;

  private Integer userid;

  private String content;

  private boolean ifDiscussion;

  public Integer getNotificationid() {
    return notificationid;
  }

  public void setNotificationid(Integer notificationid) {
    this.notificationid = notificationid;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content == null ? null : content.trim();
  }

  public boolean getIfDiscussion() {
    return ifDiscussion;
  }

  public void setIfDiscussion(boolean discussion) {
    ifDiscussion = discussion;
  }
}