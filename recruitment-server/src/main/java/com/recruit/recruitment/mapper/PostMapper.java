package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Post;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface PostMapper {
  @Delete({
    "delete from post",
    "where postid = #{postid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer postid);

  @Insert({
    "insert into post (postid, authorid, ",
    "companyname, jobname, ",
    "location, category, ",
    "salary, salarytype, ",
    "description, criteria, ",
    "due, picknum)",
    "values (#{postid,jdbcType=INTEGER}, #{authorid,jdbcType=INTEGER}, ",
    "#{companyname,jdbcType=VARCHAR}, #{jobname,jdbcType=VARCHAR}, ",
    "#{location,jdbcType=VARCHAR}, #{category,jdbcType=VARCHAR}, ",
    "#{salary,jdbcType=INTEGER}, #{salarytype,jdbcType=INTEGER}, ",
    "#{description,jdbcType=VARCHAR}, #{criteria,jdbcType=VARCHAR}, ",
    "#{due,jdbcType=DATE}, #{picknum,jdbcType=INTEGER})"
  })
  int insert(Post record);

  @InsertProvider(type = PostSqlProvider.class, method = "insertSelective")
  int insertSelective(Post record);

  @Select({
    "select",
    "postid, authorid, companyname, jobname, location, category, salary, salarytype, ",
    "description, criteria, due, picknum",
    "from post",
    "where postid = #{postid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "postid", property = "postid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "authorid", property = "authorid", jdbcType = JdbcType.INTEGER),
    @Result(column = "companyname", property = "companyname", jdbcType = JdbcType.VARCHAR),
    @Result(column = "jobname", property = "jobname", jdbcType = JdbcType.VARCHAR),
    @Result(column = "location", property = "location", jdbcType = JdbcType.VARCHAR),
    @Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR),
    @Result(column = "salary", property = "salary", jdbcType = JdbcType.INTEGER),
    @Result(column = "salarytype", property = "salarytype", jdbcType = JdbcType.INTEGER),
    @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
    @Result(column = "criteria", property = "criteria", jdbcType = JdbcType.VARCHAR),
    @Result(column = "due", property = "due", jdbcType = JdbcType.DATE),
    @Result(column = "picknum", property = "picknum", jdbcType = JdbcType.INTEGER)
  })
  Post selectByPrimaryKey(Integer postid);

  @Select({
    "select",
    "postid, authorid, companyname, jobname, location, category, salary, salarytype, ",
    "description, criteria, due, picknum",
    "from post"
  })
  @Results({
    @Result(column = "postid", property = "postid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "authorid", property = "authorid", jdbcType = JdbcType.INTEGER),
    @Result(column = "companyname", property = "companyname", jdbcType = JdbcType.VARCHAR),
    @Result(column = "jobname", property = "jobname", jdbcType = JdbcType.VARCHAR),
    @Result(column = "location", property = "location", jdbcType = JdbcType.VARCHAR),
    @Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR),
    @Result(column = "salary", property = "salary", jdbcType = JdbcType.INTEGER),
    @Result(column = "salarytype", property = "salarytype", jdbcType = JdbcType.INTEGER),
    @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR),
    @Result(column = "criteria", property = "criteria", jdbcType = JdbcType.VARCHAR),
    @Result(column = "due", property = "due", jdbcType = JdbcType.DATE),
    @Result(column = "picknum", property = "picknum", jdbcType = JdbcType.INTEGER)
  })
  List<Post> selectAll();

  @UpdateProvider(type = PostSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Post record);

  @Update({
    "update post",
    "set authorid = #{authorid,jdbcType=INTEGER},",
    "companyname = #{companyname,jdbcType=VARCHAR},",
    "jobname = #{jobname,jdbcType=VARCHAR},",
    "location = #{location,jdbcType=VARCHAR},",
    "category = #{category,jdbcType=VARCHAR},",
    "salary = #{salary,jdbcType=INTEGER},",
    "salarytype = #{salarytype,jdbcType=INTEGER},",
    "description = #{description,jdbcType=VARCHAR},",
    "criteria = #{criteria,jdbcType=VARCHAR},",
    "due = #{due,jdbcType=DATE},",
    "picknum = #{picknum,jdbcType=INTEGER}",
    "where postid = #{postid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Post record);
}