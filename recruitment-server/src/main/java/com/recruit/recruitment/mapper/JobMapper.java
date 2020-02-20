package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Job;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface JobMapper {
  @Delete({
    "delete from job",
    "where jobid = #{jobid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer jobid);

  @Delete({
    "delete from job",
    "where userid = #{userid,jdbcType=INTEGER}"
  })
  int deleteByUserid(Integer userid);

  @Insert({
    "insert into job (jobid, userid, ",
    "companyname, jobtitle, ",
    "jobstart, jobend, jobdescript)",
    "values (#{jobid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
    "#{companyname,jdbcType=VARCHAR}, #{jobtitle,jdbcType=VARCHAR}, ",
    "#{jobstart,jdbcType=DATE}, #{jobend,jdbcType=DATE}, #{jobdescript,jdbcType=VARCHAR})"
  })
  int insert(Job record);

  @InsertProvider(type = JobSqlProvider.class, method = "insertSelective")
  int insertSelective(Job record);

  @Select({
    "select",
    "jobid, userid, companyname, jobtitle, jobstart, jobend, jobdescript",
    "from job",
    "where jobid = #{jobid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "jobid", property = "jobid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "companyname", property = "companyname", jdbcType = JdbcType.VARCHAR),
    @Result(column = "jobtitle", property = "jobtitle", jdbcType = JdbcType.VARCHAR),
    @Result(column = "jobstart", property = "jobstart", jdbcType = JdbcType.DATE),
    @Result(column = "jobend", property = "jobend", jdbcType = JdbcType.DATE),
    @Result(column = "jobdescript", property = "jobdescript", jdbcType = JdbcType.VARCHAR)
  })
  Job selectByPrimaryKey(Integer jobid);

  @Select({
    "select",
    "jobid, userid, companyname, jobtitle, jobstart, jobend, jobdescript",
    "from job",
    "where userid = #{userid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "jobid", property = "jobid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "companyname", property = "companyname", jdbcType = JdbcType.VARCHAR),
    @Result(column = "jobtitle", property = "jobtitle", jdbcType = JdbcType.VARCHAR),
    @Result(column = "jobstart", property = "jobstart", jdbcType = JdbcType.DATE),
    @Result(column = "jobend", property = "jobend", jdbcType = JdbcType.DATE),
    @Result(column = "jobdescript", property = "jobdescript", jdbcType = JdbcType.VARCHAR)
  })
  List<Job> selectByUserid(Integer userid);

  @UpdateProvider(type = JobSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Job record);

  @Update({
    "update job",
    "set userid = #{userid,jdbcType=INTEGER},",
    "companyname = #{companyname,jdbcType=VARCHAR},",
    "jobtitle = #{jobtitle,jdbcType=VARCHAR},",
    "jobstart = #{jobstart,jdbcType=DATE},",
    "jobend = #{jobend,jdbcType=DATE},",
    "jobdescript = #{jobdescript,jdbcType=VARCHAR},",
    "where jobid = #{jobid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Job record);
}