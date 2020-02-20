package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Experience;
import org.apache.ibatis.jdbc.SQL;

public class ExperienceSqlProvider {
  public String insertSelective(Experience record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("experience");

    if (record.getExpid() != null) {
      sql.VALUES("expid", "#{expid,jdbcType=INTEGER}");
    }

    if (record.getUserid() != null) {
      sql.VALUES("userid", "#{userid,jdbcType=INTEGER}");
    }

    if (record.getCompanyname() != null) {
      sql.VALUES("companyname", "#{companyname,jdbcType=VARCHAR}");
    }

    if (record.getJobtitle() != null) {
      sql.VALUES("jobtitle", "#{jobtitle,jdbcType=VARCHAR}");
    }

    if (record.getJobstart() != null) {
      sql.VALUES("jobstart", "#{jobstart,jdbcType=DATE}");
    }

    if (record.getJobend() != null) {
      sql.VALUES("jobend", "#{jobend,jdbcType=DATE}");
    }

    if (record.getJobdescript() != null) {
      sql.VALUES("jobdescript", "#{jobdescript,jdbcType=VARCHAR}");
    }

    if (record.getCurjob() != null) {
      sql.VALUES("curjob", "#{curjob,jdbcType=BIT}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Experience record) {
    SQL sql = new SQL();
    sql.UPDATE("experience");

    if (record.getUserid() != null) {
      sql.SET("userid = #{userid,jdbcType=INTEGER}");
    }

    if (record.getCompanyname() != null) {
      sql.SET("companyname = #{companyname,jdbcType=VARCHAR}");
    }

    if (record.getJobtitle() != null) {
      sql.SET("jobtitle = #{jobtitle,jdbcType=VARCHAR}");
    }

    if (record.getJobstart() != null) {
      sql.SET("jobstart = #{jobstart,jdbcType=DATE}");
    }

    if (record.getJobend() != null) {
      sql.SET("jobend = #{jobend,jdbcType=DATE}");
    }

    if (record.getJobdescript() != null) {
      sql.SET("jobdescript = #{jobdescript,jdbcType=VARCHAR}");
    }

    if (record.getCurjob() != null) {
      sql.SET("curjob = #{curjob,jdbcType=BIT}");
    }

    sql.WHERE("expid = #{expid,jdbcType=INTEGER}");

    return sql.toString();
  }
}