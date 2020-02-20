package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Evaluator;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface EvaluatorMapper {
  @Delete({
    "delete from evaluator",
    "where evaluatorid = #{evaluatorid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer evaluatorid);

  @Delete({
    "delete from evaluator",
    "where postid = #{postid,jdbcType=INTEGER}"
  })
  int deleteByPostid(Integer postid);

  @Insert({
    "insert into evaluator (evaluatorid, postid, ",
    "evaluatorname)",
    "values (#{evaluatorid,jdbcType=INTEGER}, #{postid,jdbcType=INTEGER}, ",
    "#{evaluatorname,jdbcType=VARCHAR})"
  })
  int insert(Evaluator record);

  @InsertProvider(type = EvaluatorSqlProvider.class, method = "insertSelective")
  int insertSelective(Evaluator record);

  @Select({
    "select",
    "evaluatorid, postid, evaluatorname",
    "from evaluator",
    "where evaluatorid = #{evaluatorid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "evaluatorid", property = "evaluatorid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "postid", property = "postid", jdbcType = JdbcType.INTEGER),
    @Result(column = "evaluatorname", property = "evaluatorname", jdbcType = JdbcType.VARCHAR)
  })
  Evaluator selectByPrimaryKey(Integer evaluatorid);

  @Select({
    "select",
    "evaluatorid, postid, evaluatorname",
    "from evaluator",
    "where evaluatorname = #{evaluatorname,jdbcType=VARCHAR}"
  })
  @Results({
    @Result(column = "evaluatorid", property = "evaluatorid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "postid", property = "postid", jdbcType = JdbcType.INTEGER),
    @Result(column = "evaluatorname", property = "evaluatorname", jdbcType = JdbcType.VARCHAR)
  })
  List<Evaluator> selectByEvaluatorName(String evaluatorName);

  @Select({
    "select",
    "evaluatorname",
    "from evaluator",
    "where postid = #{postid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "evaluatorname", property = "evaluatorname", jdbcType = JdbcType.VARCHAR)
  })
  List<String> selectEvaluatorNameByPostid(Integer postid);

  @UpdateProvider(type = EvaluatorSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Evaluator record);

  @Update({
    "update evaluator",
    "set postid = #{postid,jdbcType=INTEGER},",
    "evaluatorname = #{evaluatorname,jdbcType=VARCHAR}",
    "where evaluatorid = #{evaluatorid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Evaluator record);
}