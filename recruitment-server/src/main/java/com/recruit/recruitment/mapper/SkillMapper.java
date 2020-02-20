package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Skill;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SkillMapper {
  @Delete({
    "delete from skill",
    "where skillid = #{skillid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer skillid);

  @Insert({
    "insert into skill (skillid, userid, ",
    "skillname, skillprof)",
    "values (#{skillid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
    "#{skillname,jdbcType=VARCHAR}, #{skillprof,jdbcType=INTEGER})"
  })
  int insert(Skill record);

  @InsertProvider(type = SkillSqlProvider.class, method = "insertSelective")
  int insertSelective(Skill record);

  @Select({
    "select",
    "skillid, userid, skillname, skillprof",
    "from skill",
    "where skillid = #{skillid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "skillid", property = "skillid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "skillname", property = "skillname", jdbcType = JdbcType.VARCHAR),
    @Result(column = "skillprof", property = "skillprof", jdbcType = JdbcType.INTEGER)
  })
  Skill selectByPrimaryKey(Integer skillid);

  @Select({
    "select",
    "skillid, userid, skillname, skillprof",
    "from skill"
  })
  @Results({
    @Result(column = "skillid", property = "skillid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "skillname", property = "skillname", jdbcType = JdbcType.VARCHAR),
    @Result(column = "skillprof", property = "skillprof", jdbcType = JdbcType.INTEGER)
  })
  List<Skill> selectAll();

  @UpdateProvider(type = SkillSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Skill record);

  @Update({
    "update skill",
    "set userid = #{userid,jdbcType=INTEGER},",
    "skillname = #{skillname,jdbcType=VARCHAR},",
    "skillprof = #{skillprof,jdbcType=INTEGER}",
    "where skillid = #{skillid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Skill record);
}