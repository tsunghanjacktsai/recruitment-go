package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Post;
import org.apache.ibatis.jdbc.SQL;

public class PostSqlProvider {
  public String insertSelective(Post record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("post");

    if (record.getPostid() != null) {
      sql.VALUES("postid", "#{postid,jdbcType=INTEGER}");
    }

    if (record.getAuthorid() != null) {
      sql.VALUES("authorid", "#{authorid,jdbcType=INTEGER}");
    }

    if (record.getCompanyname() != null) {
      sql.VALUES("companyname", "#{companyname,jdbcType=VARCHAR}");
    }

    if (record.getJobname() != null) {
      sql.VALUES("jobname", "#{jobname,jdbcType=VARCHAR}");
    }

    if (record.getLocation() != null) {
      sql.VALUES("location", "#{location,jdbcType=VARCHAR}");
    }

    if (record.getCategory() != null) {
      sql.VALUES("category", "#{category,jdbcType=VARCHAR}");
    }

    if (record.getSalary() != null) {
      sql.VALUES("salary", "#{salary,jdbcType=INTEGER}");
    }

    if (record.getSalarytype() != null) {
      sql.VALUES("salarytype", "#{salarytype,jdbcType=INTEGER}");
    }

    if (record.getDescription() != null) {
      sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
    }

    if (record.getCriteria() != null) {
      sql.VALUES("criteria", "#{criteria,jdbcType=VARCHAR}");
    }

    if (record.getDue() != null) {
      sql.VALUES("due", "#{due,jdbcType=DATE}");
    }

    if (record.getPicknum() != null) {
      sql.VALUES("picknum", "#{picknum,jdbcType=INTEGER}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Post record) {
    SQL sql = new SQL();
    sql.UPDATE("post");

    if (record.getAuthorid() != null) {
      sql.SET("authorid = #{authorid,jdbcType=INTEGER}");
    }

    if (record.getCompanyname() != null) {
      sql.SET("companyname = #{companyname,jdbcType=VARCHAR}");
    }

    if (record.getJobname() != null) {
      sql.SET("jobname = #{jobname,jdbcType=VARCHAR}");
    }

    if (record.getLocation() != null) {
      sql.SET("location = #{location,jdbcType=VARCHAR}");
    }

    if (record.getCategory() != null) {
      sql.SET("category = #{category,jdbcType=VARCHAR}");
    }

    if (record.getSalary() != null) {
      sql.SET("salary = #{salary,jdbcType=INTEGER}");
    }

    if (record.getSalarytype() != null) {
      sql.SET("salarytype = #{salarytype,jdbcType=INTEGER}");
    }

    if (record.getDescription() != null) {
      sql.SET("description = #{description,jdbcType=VARCHAR}");
    }

    if (record.getCriteria() != null) {
      sql.SET("criteria = #{criteria,jdbcType=VARCHAR}");
    }

    if (record.getDue() != null) {
      sql.SET("due = #{due,jdbcType=DATE}");
    }

    if (record.getPicknum() != null) {
      sql.SET("picknum = #{picknum,jdbcType=INTEGER}");
    }

    sql.WHERE("postid = #{postid,jdbcType=INTEGER}");

    return sql.toString();
  }
}