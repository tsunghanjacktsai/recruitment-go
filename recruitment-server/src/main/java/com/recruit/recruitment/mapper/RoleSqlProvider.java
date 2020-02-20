package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Role;
import org.apache.ibatis.jdbc.SQL;

public class RoleSqlProvider {
  public String insertSelective(Role record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("role");

    if (record.getRoleid() != null) {
      sql.VALUES("roleid", "#{roleid,jdbcType=INTEGER}");
    }

    if (record.getRolename() != null) {
      sql.VALUES("rolename", "#{rolename,jdbcType=VARCHAR}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Role record) {
    SQL sql = new SQL();
    sql.UPDATE("role");

    if (record.getRolename() != null) {
      sql.SET("rolename = #{rolename,jdbcType=VARCHAR}");
    }

    sql.WHERE("roleid = #{roleid,jdbcType=INTEGER}");

    return sql.toString();
  }
}