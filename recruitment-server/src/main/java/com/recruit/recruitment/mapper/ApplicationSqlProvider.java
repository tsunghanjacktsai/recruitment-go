package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Application;
import org.apache.ibatis.jdbc.SQL;

public class ApplicationSqlProvider {
  public String insertSelective(Application record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("application");

    if (record.getApplicationid() != null) {
      sql.VALUES("applicationid", "#{applicationid,jdbcType=INTEGER}");
    }

    if (record.getResumeid() != null) {
      sql.VALUES("resumeid", "#{resumeid,jdbcType=INTEGER}");
    }

    if (record.getPostid() != null) {
      sql.VALUES("postid", "#{postid,jdbcType=INTEGER}");
    }

    if (record.getScoreavg() != null) {
      sql.VALUES("scoreavg", "#{scoreavg,jdbcType=DECIMAL}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Application record) {
    SQL sql = new SQL();
    sql.UPDATE("application");

    if (record.getResumeid() != null) {
      sql.SET("resumeid = #{resumeid,jdbcType=INTEGER}");
    }

    if (record.getPostid() != null) {
      sql.SET("postid = #{postid,jdbcType=INTEGER}");
    }

    if (record.getScoreavg() != null) {
      sql.SET("scoreavg = #{scoreavg,jdbcType=DECIMAL}");
    }

    sql.WHERE("applicationid = #{applicationid,jdbcType=INTEGER}");

    return sql.toString();
  }
}