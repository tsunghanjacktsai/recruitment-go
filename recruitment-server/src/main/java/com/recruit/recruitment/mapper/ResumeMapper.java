package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Resume;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ResumeMapper {
  @Delete({
    "delete from resume",
    "where resumeid = #{resumeid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer resumeid);

  @Insert({
    "insert into resume (resumeid, userid, ",
    "name, age, phone, ",
    "location, intention, ",
    "website, statement, ",
    "degree, major, school, ",
    "edustart, eduend, edudescript, ",
    "score)",
    "values (#{resumeid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
    "#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, #{phone,jdbcType=VARCHAR}, ",
    "#{location,jdbcType=VARCHAR}, #{intention,jdbcType=VARCHAR}, ",
    "#{website,jdbcType=VARCHAR}, #{statement,jdbcType=VARCHAR}, ",
    "#{degree,jdbcType=VARCHAR}, #{major,jdbcType=VARCHAR}, #{school,jdbcType=VARCHAR}, ",
    "#{edustart,jdbcType=DATE}, #{eduend,jdbcType=DATE}, #{edudescript,jdbcType=VARCHAR}, ",
    "#{score,jdbcType=VARCHAR})"
  })
  int insert(Resume record);

  @InsertProvider(type = ResumeSqlProvider.class, method = "insertSelective")
  int insertSelective(Resume record);

  @Select({
    "select",
    "resumeid, userid, name, age, phone, location, intention, website, statement, ",
    "degree, major, school, edustart, eduend, edudescript, score",
    "from resume",
    "where resumeid = #{resumeid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "resumeid", property = "resumeid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
    @Result(column = "age", property = "age", jdbcType = JdbcType.INTEGER),
    @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
    @Result(column = "location", property = "location", jdbcType = JdbcType.VARCHAR),
    @Result(column = "intention", property = "intention", jdbcType = JdbcType.VARCHAR),
    @Result(column = "website", property = "website", jdbcType = JdbcType.VARCHAR),
    @Result(column = "statement", property = "statement", jdbcType = JdbcType.VARCHAR),
    @Result(column = "degree", property = "degree", jdbcType = JdbcType.VARCHAR),
    @Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
    @Result(column = "school", property = "school", jdbcType = JdbcType.VARCHAR),
    @Result(column = "edustart", property = "edustart", jdbcType = JdbcType.DATE),
    @Result(column = "eduend", property = "eduend", jdbcType = JdbcType.DATE),
    @Result(column = "edudescript", property = "edudescript", jdbcType = JdbcType.VARCHAR),
    @Result(column = "score", property = "score", jdbcType = JdbcType.VARCHAR)
  })
  Resume selectByPrimaryKey(Integer resumeid);

  @UpdateProvider(type = ResumeSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Resume record);

  @Update({
    "update resume",
    "set userid = #{userid,jdbcType=INTEGER},",
    "name = #{name,jdbcType=VARCHAR},",
    "age = #{age,jdbcType=INTEGER},",
    "phone = #{phone,jdbcType=VARCHAR},",
    "location = #{location,jdbcType=VARCHAR},",
    "intention = #{intention,jdbcType=VARCHAR},",
    "website = #{website,jdbcType=VARCHAR},",
    "statement = #{statement,jdbcType=VARCHAR},",
    "degree = #{degree,jdbcType=VARCHAR},",
    "major = #{major,jdbcType=VARCHAR},",
    "school = #{school,jdbcType=VARCHAR},",
    "edustart = #{edustart,jdbcType=DATE},",
    "eduend = #{eduend,jdbcType=DATE},",
    "edudescript = #{edudescript,jdbcType=VARCHAR},",
    "score = #{score,jdbcType=VARCHAR}",
    "where resumeid = #{resumeid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Resume record);
}