package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Company;
import org.apache.ibatis.jdbc.SQL;

public class CompanySqlProvider {
  public String insertSelective(Company record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("company");

    if (record.getCompanyid() != null) {
      sql.VALUES("companyid", "#{companyid,jdbcType=INTEGER}");
    }

    if (record.getCompanyname() != null) {
      sql.VALUES("companyname", "#{companyname,jdbcType=VARCHAR}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Company record) {
    SQL sql = new SQL();
    sql.UPDATE("company");

    if (record.getCompanyname() != null) {
      sql.SET("companyname = #{companyname,jdbcType=VARCHAR}");
    }

    sql.WHERE("companyid = #{companyid,jdbcType=INTEGER}");

    return sql.toString();
  }
}