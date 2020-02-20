package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Evaluator;
import org.apache.ibatis.jdbc.SQL;

public class EvaluatorSqlProvider {
  public String insertSelective(Evaluator record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("evaluator");

    if (record.getEvaluatorid() != null) {
      sql.VALUES("evaluatorid", "#{evaluatorid,jdbcType=INTEGER}");
    }

    if (record.getPostid() != null) {
      sql.VALUES("postid", "#{postid,jdbcType=INTEGER}");
    }

    if (record.getEvaluatorname() != null) {
      sql.VALUES("evaluatorname", "#{evaluatorname,jdbcType=VARCHAR}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Evaluator record) {
    SQL sql = new SQL();
    sql.UPDATE("evaluator");

    if (record.getPostid() != null) {
      sql.SET("postid = #{postid,jdbcType=INTEGER}");
    }

    if (record.getEvaluatorname() != null) {
      sql.SET("evaluatorname = #{evaluatorname,jdbcType=VARCHAR}");
    }

    sql.WHERE("evaluatorid = #{evaluatorid,jdbcType=INTEGER}");

    return sql.toString();
  }
}