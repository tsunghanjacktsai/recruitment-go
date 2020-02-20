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

    if (record.getUserid() != null) {
      sql.VALUES("userid", "#{userid,jdbcType=INTEGER}");
    }

    if (record.getPostid() != null) {
      sql.VALUES("postid", "#{postid,jdbcType=INTEGER}");
    }

    if (record.getStatus() != null) {
      sql.VALUES("status", "#{status,jdbcType=BIT}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Application record) {
    SQL sql = new SQL();
    sql.UPDATE("application");

    if (record.getUserid() != null) {
      sql.SET("userid = #{userid,jdbcType=INTEGER}");
    }

    if (record.getPostid() != null) {
      sql.SET("postid = #{postid,jdbcType=INTEGER}");
    }

    if (record.getStatus() != null) {
      sql.SET("status = #{status,jdbcType=BIT}");
    }

    sql.WHERE("applicationid = #{applicationid,jdbcType=INTEGER}");

    return sql.toString();
  }
}