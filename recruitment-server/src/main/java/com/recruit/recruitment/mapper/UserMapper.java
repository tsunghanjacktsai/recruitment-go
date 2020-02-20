package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserMapper {
  @Delete({
    "delete from user",
    "where userid = #{userid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer userid);

  @Insert({
    "insert into user (userid, mail, ",
    "password, username)",
    "values (#{userid,jdbcType=INTEGER}, #{mail,jdbcType=VARCHAR}, ",
    "#{password,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR})"
  })
  int insert(User record);

  @InsertProvider(type = UserSqlProvider.class, method = "insertSelective")
  @Options(useGeneratedKeys=true, keyProperty="userid")
  int insertSelective(User record);

  @Select({
    "select",
    "userid, mail, password, username",
    "from user",
    "where userid = #{userid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "mail", property = "mail", jdbcType = JdbcType.VARCHAR),
    @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
    @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR)
  })
  User selectByPrimaryKey(Integer userid);

  @Select({
    "select",
    "userid, mail, password, username",
    "from user",
    "where username = #{username, jdbcType=VARCHAR}"
  })
  @Results({
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "mail", property = "mail", jdbcType = JdbcType.VARCHAR),
    @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
    @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR)
  })
  User selectByUsername(String username);

  @Select({
    "select",
    "userid, mail, password, username",
    "from user",
    "where mail = #{mail, jdbcType=VARCHAR}"
  })
  @Results({
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "mail", property = "mail", jdbcType = JdbcType.VARCHAR),
    @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
    @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR)
  })
  User selectByMail(String mail);

  @Select({
    "select",
    "userid, mail, password, username",
    "from user"
  })
  @Results({
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "mail", property = "mail", jdbcType = JdbcType.VARCHAR),
    @Result(column = "password", property = "password", jdbcType = JdbcType.VARCHAR),
    @Result(column = "username", property = "username", jdbcType = JdbcType.VARCHAR)
  })
  List<User> selectAll();

  @UpdateProvider(type = UserSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(User record);

  @Update({
    "update user",
    "set mail = #{mail,jdbcType=VARCHAR},",
    "password = #{password,jdbcType=VARCHAR},",
    "username = #{username,jdbcType=VARCHAR}",
    "where userid = #{userid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(User record);
}