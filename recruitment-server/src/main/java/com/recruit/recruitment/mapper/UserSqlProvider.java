package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {
  public String insertSelective(User record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("user");

    if (record.getUserid() != null) {
      sql.VALUES("userid", "#{userid,jdbcType=INTEGER}");
    }

    if (record.getMail() != null) {
      sql.VALUES("mail", "#{mail,jdbcType=VARCHAR}");
    }

    if (record.getPassword() != null) {
      sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
    }

    if (record.getUsername() != null) {
      sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(User record) {
    SQL sql = new SQL();
    sql.UPDATE("user");

    if (record.getMail() != null) {
      sql.SET("mail = #{mail,jdbcType=VARCHAR}");
    }

    if (record.getPassword() != null) {
      sql.SET("password = #{password,jdbcType=VARCHAR}");
    }

    if (record.getUsername() != null) {
      sql.SET("username = #{username,jdbcType=VARCHAR}");
    }

    sql.WHERE("userid = #{userid,jdbcType=INTEGER}");

    return sql.toString();
  }
}