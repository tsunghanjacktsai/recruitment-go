package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Score;
import org.apache.ibatis.jdbc.SQL;

public class ScoreSqlProvider {
  public String insertSelective(Score record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("score");

    if (record.getScoreid() != null) {
      sql.VALUES("scoreid", "#{scoreid,jdbcType=INTEGER}");
    }

    if (record.getMarkerid() != null) {
      sql.VALUES("markerid", "#{markerid,jdbcType=INTEGER}");
    }

    if (record.getApplicationid() != null) {
      sql.VALUES("applicationid", "#{applicationid,jdbcType=INTEGER}");
    }

    if (record.getScore() != null) {
      sql.VALUES("score", "#{score,jdbcType=DECIMAL}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Score record) {
    SQL sql = new SQL();
    sql.UPDATE("score");

    if (record.getMarkerid() != null) {
      sql.SET("markerid = #{markerid,jdbcType=INTEGER}");
    }

    if (record.getApplicationid() != null) {
      sql.SET("applicationid = #{applicationid,jdbcType=INTEGER}");
    }

    if (record.getScore() != null) {
      sql.SET("score = #{score,jdbcType=DECIMAL}");
    }

    sql.WHERE("scoreid = #{scoreid,jdbcType=INTEGER}");

    return sql.toString();
  }
}