package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Resume;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ResumeMapper {
  @Delete({
    "delete from resume",
    "where resumeid = #{resumeid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer resumeid);

  @Insert({
    "insert into resume (resumeid, userid, mail,",
    "name, phone, location, ",
    "intention, website, ",
    "statement, major, ",
    "school, edustart, eduend, ",
    "edudescript)",
    "values (#{resumeid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, #{mail,jdbcType=VARCHAR}",
    "#{name,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{location,jdbcType=VARCHAR}, ",
    "#{intention,jdbcType=VARCHAR}, #{website,jdbcType=VARCHAR}, ",
    "#{statement,jdbcType=VARCHAR}, #{major,jdbcType=VARCHAR}, ",
    "#{school,jdbcType=VARCHAR}, #{edustart,jdbcType=DATE}, #{eduend,jdbcType=DATE}, ",
    "#{edudescript,jdbcType=VARCHAR}"
  })
  int insert(Resume record);

  @InsertProvider(type = ResumeSqlProvider.class, method = "insertSelective")
  int insertSelective(Resume record);

  @Select({
    "select",
    "resumeid, userid, mail, name, phone, location, intention, website, statement, major, ",
    "school, edustart, eduend, edudescript",
    "from resume",
    "where userid = #{userid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "resumeid", property = "resumeid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "mail", property = "mail", jdbcType = JdbcType.VARCHAR),
    @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
    @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
    @Result(column = "location", property = "location", jdbcType = JdbcType.VARCHAR),
    @Result(column = "intention", property = "intention", jdbcType = JdbcType.VARCHAR),
    @Result(column = "website", property = "website", jdbcType = JdbcType.VARCHAR),
    @Result(column = "statement", property = "statement", jdbcType = JdbcType.VARCHAR),
    @Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
    @Result(column = "school", property = "school", jdbcType = JdbcType.VARCHAR),
    @Result(column = "edustart", property = "edustart", jdbcType = JdbcType.DATE),
    @Result(column = "eduend", property = "eduend", jdbcType = JdbcType.DATE),
    @Result(column = "edudescript", property = "edudescript", jdbcType = JdbcType.VARCHAR)
  })
  Resume selectByUserid(Integer userid);

  @Select({
    "select",
    "resumeid, userid, mail, name, phone, location, intention, website, statement, major, ",
    "school, edustart, eduend, edudescript",
    "from resume",
    "where resumeid = #{resumeid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "resumeid", property = "resumeid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "mail", property = "mail", jdbcType = JdbcType.VARCHAR),
    @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
    @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
    @Result(column = "location", property = "location", jdbcType = JdbcType.VARCHAR),
    @Result(column = "intention", property = "intention", jdbcType = JdbcType.VARCHAR),
    @Result(column = "website", property = "website", jdbcType = JdbcType.VARCHAR),
    @Result(column = "statement", property = "statement", jdbcType = JdbcType.VARCHAR),
    @Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
    @Result(column = "school", property = "school", jdbcType = JdbcType.VARCHAR),
    @Result(column = "edustart", property = "edustart", jdbcType = JdbcType.DATE),
    @Result(column = "eduend", property = "eduend", jdbcType = JdbcType.DATE),
    @Result(column = "edudescript", property = "edudescript", jdbcType = JdbcType.VARCHAR)
  })
  Resume selectByPrimaryKey(Integer resumeid);

  @Select({
    "select",
    "resumeid, userid, mail, name, phone, location, intention, website, statement, major, ",
    "school, edustart, eduend, edudescript",
    "from resume"
  })
  @Results({
    @Result(column = "resumeid", property = "resumeid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "mail", property = "mail", jdbcType = JdbcType.VARCHAR),
    @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
    @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
    @Result(column = "location", property = "location", jdbcType = JdbcType.VARCHAR),
    @Result(column = "intention", property = "intention", jdbcType = JdbcType.VARCHAR),
    @Result(column = "website", property = "website", jdbcType = JdbcType.VARCHAR),
    @Result(column = "statement", property = "statement", jdbcType = JdbcType.VARCHAR),
    @Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
    @Result(column = "school", property = "school", jdbcType = JdbcType.VARCHAR),
    @Result(column = "edustart", property = "edustart", jdbcType = JdbcType.DATE),
    @Result(column = "eduend", property = "eduend", jdbcType = JdbcType.DATE),
    @Result(column = "edudescript", property = "edudescript", jdbcType = JdbcType.VARCHAR)
  })
  List<Resume> selectAll();

  @UpdateProvider(type = ResumeSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Resume record);

  @Update({
    "update resume",
    "set userid = #{userid,jdbcType=INTEGER},",
    "mail = #{mail,jdbcType=VARCHAR}",
    "name = #{name,jdbcType=VARCHAR},",
    "phone = #{phone,jdbcType=VARCHAR},",
    "location = #{location,jdbcType=VARCHAR},",
    "intention = #{intention,jdbcType=VARCHAR},",
    "website = #{website,jdbcType=VARCHAR},",
    "statement = #{statement,jdbcType=VARCHAR},",
    "major = #{major,jdbcType=VARCHAR},",
    "school = #{school,jdbcType=VARCHAR},",
    "edustart = #{edustart,jdbcType=DATE},",
    "eduend = #{eduend,jdbcType=DATE},",
    "edudescript = #{edudescript,jdbcType=VARCHAR},",
    "where resumeid = #{resumeid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Resume record);
}