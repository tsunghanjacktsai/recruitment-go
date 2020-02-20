package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Job;
import org.apache.ibatis.jdbc.SQL;

public class JobSqlProvider {
  public String insertSelective(Job record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("job");

    if (record.getJobid() != null) {
      sql.VALUES("jobid", "#{jobid,jdbcType=INTEGER}");
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

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Job record) {
    SQL sql = new SQL();
    sql.UPDATE("job");

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

    sql.WHERE("jobid = #{jobid,jdbcType=INTEGER}");

    return sql.toString();
  }
}