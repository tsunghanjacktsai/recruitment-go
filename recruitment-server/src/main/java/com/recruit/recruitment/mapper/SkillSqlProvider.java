package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Skill;
import org.apache.ibatis.jdbc.SQL;

public class SkillSqlProvider {
  public String insertSelective(Skill record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("skill");

    if (record.getSkillid() != null) {
      sql.VALUES("skillid", "#{skillid,jdbcType=INTEGER}");
    }

    if (record.getUserid() != null) {
      sql.VALUES("userid", "#{userid,jdbcType=INTEGER}");
    }

    if (record.getSkillname() != null) {
      sql.VALUES("skillname", "#{skillname,jdbcType=VARCHAR}");
    }

    if (record.getSkillprof() != null) {
      sql.VALUES("skillprof", "#{skillprof,jdbcType=INTEGER}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Skill record) {
    SQL sql = new SQL();
    sql.UPDATE("skill");

    if (record.getUserid() != null) {
      sql.SET("userid = #{userid,jdbcType=INTEGER}");
    }

    if (record.getSkillname() != null) {
      sql.SET("skillname = #{skillname,jdbcType=VARCHAR}");
    }

    if (record.getSkillprof() != null) {
      sql.SET("skillprof = #{skillprof,jdbcType=INTEGER}");
    }

    sql.WHERE("skillid = #{skillid,jdbcType=INTEGER}");

    return sql.toString();
  }
}