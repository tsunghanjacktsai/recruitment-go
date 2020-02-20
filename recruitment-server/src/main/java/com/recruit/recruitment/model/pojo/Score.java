package com.recruit.recruitment.model.pojo;

import java.math.BigDecimal;

public class Score {
  private Integer scoreid;

  private Integer markerid;

  private Integer applicationid;

  private BigDecimal score;

  public Integer getScoreid() {
    return scoreid;
  }

  public void setScoreid(Integer scoreid) {
    this.scoreid = scoreid;
  }

  public Integer getMarkerid() {
    return markerid;
  }

  public void setMarkerid(Integer markerid) {
    this.markerid = markerid;
  }

  public Integer getApplicationid() {
    return applicationid;
  }

  public void setApplicationid(Integer applicationid) {
    this.applicationid = applicationid;
  }

  public BigDecimal getScore() {
    return score;
  }

  public void setScore(BigDecimal score) {
    this.score = score;
  }
}