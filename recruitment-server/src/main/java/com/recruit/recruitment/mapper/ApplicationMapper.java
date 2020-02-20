package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Application;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface ApplicationMapper {
  @Delete({
    "delete from application",
    "where applicationid = #{applicationid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer applicationid);

  @Insert({
    "insert into application (applicationid, userid, ",
    "postid, status)",
    "values (#{applicationid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
    "#{postid,jdbcType=INTEGER}, #{status,jdbcType=BIT})"
  })
  int insert(Application record);

  @InsertProvider(type = ApplicationSqlProvider.class, method = "insertSelective")
  int insertSelective(Application record);

  @Select({
    "select",
    "applicationid, userid, postid, status",
    "from application",
    "where applicationid = #{applicationid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "applicationid", property = "applicationid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "postid", property = "postid", jdbcType = JdbcType.INTEGER),
    @Result(column = "status", property = "status", jdbcType = JdbcType.BIT)
  })
  Application selectByPrimaryKey(Integer applicationid);

  @UpdateProvider(type = ApplicationSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Application record);

  @Update({
    "update application",
    "set userid = #{userid,jdbcType=INTEGER},",
    "postid = #{postid,jdbcType=INTEGER},",
    "status = #{status,jdbcType=BIT}",
    "where applicationid = #{applicationid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Application record);
}