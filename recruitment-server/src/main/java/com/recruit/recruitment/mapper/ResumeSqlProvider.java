package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Resume;
import org.apache.ibatis.jdbc.SQL;

public class ResumeSqlProvider {
  public String insertSelective(Resume record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("resume");

    if (record.getResumeid() != null) {
      sql.VALUES("resumeid", "#{resumeid,jdbcType=INTEGER}");
    }

    if (record.getUserid() != null) {
      sql.VALUES("userid", "#{userid,jdbcType=INTEGER}");
    }

    if (record.getName() != null) {
      sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
    }

    if (record.getAge() != null) {
      sql.VALUES("age", "#{age,jdbcType=INTEGER}");
    }

    if (record.getPhone() != null) {
      sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
    }

    if (record.getLocation() != null) {
      sql.VALUES("location", "#{location,jdbcType=VARCHAR}");
    }

    if (record.getIntention() != null) {
      sql.VALUES("intention", "#{intention,jdbcType=VARCHAR}");
    }

    if (record.getWebsite() != null) {
      sql.VALUES("website", "#{website,jdbcType=VARCHAR}");
    }

    if (record.getStatement() != null) {
      sql.VALUES("statement", "#{statement,jdbcType=VARCHAR}");
    }

    if (record.getDegree() != null) {
      sql.VALUES("degree", "#{degree,jdbcType=VARCHAR}");
    }

    if (record.getMajor() != null) {
      sql.VALUES("major", "#{major,jdbcType=VARCHAR}");
    }

    if (record.getSchool() != null) {
      sql.VALUES("school", "#{school,jdbcType=VARCHAR}");
    }

    if (record.getEdustart() != null) {
      sql.VALUES("edustart", "#{edustart,jdbcType=DATE}");
    }

    if (record.getEduend() != null) {
      sql.VALUES("eduend", "#{eduend,jdbcType=DATE}");
    }

    if (record.getEdudescript() != null) {
      sql.VALUES("edudescript", "#{edudescript,jdbcType=VARCHAR}");
    }

    if (record.getScore() != null) {
      sql.VALUES("score", "#{score,jdbcType=VARCHAR}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Resume record) {
    SQL sql = new SQL();
    sql.UPDATE("resume");

    if (record.getUserid() != null) {
      sql.SET("userid = #{userid,jdbcType=INTEGER}");
    }

    if (record.getName() != null) {
      sql.SET("name = #{name,jdbcType=VARCHAR}");
    }

    if (record.getAge() != null) {
      sql.SET("age = #{age,jdbcType=INTEGER}");
    }

    if (record.getPhone() != null) {
      sql.SET("phone = #{phone,jdbcType=VARCHAR}");
    }

    if (record.getLocation() != null) {
      sql.SET("location = #{location,jdbcType=VARCHAR}");
    }

    if (record.getIntention() != null) {
      sql.SET("intention = #{intention,jdbcType=VARCHAR}");
    }

    if (record.getWebsite() != null) {
      sql.SET("website = #{website,jdbcType=VARCHAR}");
    }

    if (record.getStatement() != null) {
      sql.SET("statement = #{statement,jdbcType=VARCHAR}");
    }

    if (record.getDegree() != null) {
      sql.SET("degree = #{degree,jdbcType=VARCHAR}");
    }

    if (record.getMajor() != null) {
      sql.SET("major = #{major,jdbcType=VARCHAR}");
    }

    if (record.getSchool() != null) {
      sql.SET("school = #{school,jdbcType=VARCHAR}");
    }

    if (record.getEdustart() != null) {
      sql.SET("edustart = #{edustart,jdbcType=DATE}");
    }

    if (record.getEduend() != null) {
      sql.SET("eduend = #{eduend,jdbcType=DATE}");
    }

    if (record.getEdudescript() != null) {
      sql.SET("edudescript = #{edudescript,jdbcType=VARCHAR}");
    }

    if (record.getScore() != null) {
      sql.SET("score = #{score,jdbcType=VARCHAR}");
    }

    sql.WHERE("resumeid = #{resumeid,jdbcType=INTEGER}");

    return sql.toString();
  }
}