package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Experience;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ExperienceMapper {
  @Delete({
    "delete from experience",
    "where expid = #{expid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer expid);

  @Insert({
    "insert into experience (expid, userid, ",
    "companyname, jobtitle, ",
    "jobstart, jobend, jobdescript, ",
    "curjob)",
    "values (#{expid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
    "#{companyname,jdbcType=VARCHAR}, #{jobtitle,jdbcType=VARCHAR}, ",
    "#{jobstart,jdbcType=DATE}, #{jobend,jdbcType=DATE}, #{jobdescript,jdbcType=VARCHAR}, ",
    "#{curjob,jdbcType=BIT})"
  })
  int insert(Experience record);

  @InsertProvider(type = ExperienceSqlProvider.class, method = "insertSelective")
  int insertSelective(Experience record);

  @Select({
    "select",
    "expid, userid, companyname, jobtitle, jobstart, jobend, jobdescript, curjob",
    "from experience",
    "where expid = #{expid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "expid", property = "expid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "companyname", property = "companyname", jdbcType = JdbcType.VARCHAR),
    @Result(column = "jobtitle", property = "jobtitle", jdbcType = JdbcType.VARCHAR),
    @Result(column = "jobstart", property = "jobstart", jdbcType = JdbcType.DATE),
    @Result(column = "jobend", property = "jobend", jdbcType = JdbcType.DATE),
    @Result(column = "jobdescript", property = "jobdescript", jdbcType = JdbcType.VARCHAR),
    @Result(column = "curjob", property = "curjob", jdbcType = JdbcType.BIT)
  })
  Experience selectByPrimaryKey(Integer expid);

  @Select({
    "select",
    "expid, userid, companyname, jobtitle, jobstart, jobend, jobdescript, curjob",
    "from experience"
  })
  @Results({
    @Result(column = "expid", property = "expid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "companyname", property = "companyname", jdbcType = JdbcType.VARCHAR),
    @Result(column = "jobtitle", property = "jobtitle", jdbcType = JdbcType.VARCHAR),
    @Result(column = "jobstart", property = "jobstart", jdbcType = JdbcType.DATE),
    @Result(column = "jobend", property = "jobend", jdbcType = JdbcType.DATE),
    @Result(column = "jobdescript", property = "jobdescript", jdbcType = JdbcType.VARCHAR),
    @Result(column = "curjob", property = "curjob", jdbcType = JdbcType.BIT)
  })
  List<Experience> selectAll();

  @UpdateProvider(type = ExperienceSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Experience record);

  @Update({
    "update experience",
    "set userid = #{userid,jdbcType=INTEGER},",
    "companyname = #{companyname,jdbcType=VARCHAR},",
    "jobtitle = #{jobtitle,jdbcType=VARCHAR},",
    "jobstart = #{jobstart,jdbcType=DATE},",
    "jobend = #{jobend,jdbcType=DATE},",
    "jobdescript = #{jobdescript,jdbcType=VARCHAR},",
    "curjob = #{curjob,jdbcType=BIT}",
    "where expid = #{expid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Experience record);
}