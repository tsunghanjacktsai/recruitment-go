package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Application;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ApplicationMapper {
  @Delete({
    "delete from application",
    "where applicationid = #{applicationid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer applicationid);

  @Insert({
    "insert into application (applicationid, resumeid, ",
    "postid, scoreavg)",
    "values (#{applicationid,jdbcType=INTEGER}, #{resumeid,jdbcType=INTEGER}, ",
    "#{postid,jdbcType=INTEGER}, #{scoreavg,jdbcType=DECIMAL})"
  })
  int insert(Application record);

  @InsertProvider(type = ApplicationSqlProvider.class, method = "insertSelective")
  int insertSelective(Application record);

  @Select({
    "select",
    "applicationid, resumeid, postid, scoreavg",
    "from application",
    "where applicationid = #{applicationid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "applicationid", property = "applicationid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "resumeid", property = "resumeid", jdbcType = JdbcType.INTEGER),
    @Result(column = "postid", property = "postid", jdbcType = JdbcType.INTEGER),
    @Result(column = "scoreavg", property = "scoreavg", jdbcType = JdbcType.DECIMAL)
  })
  Application selectByPrimaryKey(Integer applicationid);

  @Select({
    "select",
    "applicationid, resumeid, postid, scoreavg",
    "from application",
    "where postid = #{postid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "applicationid", property = "applicationid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "resumeid", property = "resumeid", jdbcType = JdbcType.INTEGER),
    @Result(column = "postid", property = "postid", jdbcType = JdbcType.INTEGER),
    @Result(column = "scoreavg", property = "scoreavg", jdbcType = JdbcType.DECIMAL),
  })
  List<Application> selectByPostid(Integer postid);

  @Select({
    "select",
    "applicationid, resumeid, postid, scoreavg",
    "from application",
    "where resumeid = #{resumeid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "applicationid", property = "applicationid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "resumeid", property = "resumeid", jdbcType = JdbcType.INTEGER),
    @Result(column = "postid", property = "postid", jdbcType = JdbcType.INTEGER),
    @Result(column = "scoreavg", property = "scoreavg", jdbcType = JdbcType.DECIMAL),
  })
  List<Application> selectByResumeid(Integer resumeid);

  @UpdateProvider(type = ApplicationSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Application record);

  @Update({
    "update application",
    "set resumeid = #{resumeid,jdbcType=INTEGER},",
    "postid = #{postid,jdbcType=INTEGER},",
    "scoreavg = #{scoreavg,jdbcType=DECIMAL}",
    "where applicationid = #{applicationid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Application record);
}