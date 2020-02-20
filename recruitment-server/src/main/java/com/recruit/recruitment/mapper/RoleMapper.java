package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RoleMapper {
  @Delete({
    "delete from role",
    "where roleid = #{roleid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer roleid);

  @Insert({
    "insert into role (roleid, rolename)",
    "values (#{roleid,jdbcType=INTEGER}, #{rolename,jdbcType=VARCHAR})"
  })
  int insert(Role record);

  @Insert({
    "insert into user_role (userroleid, userid, roleid)",
    "values (null, #{userid, jdbcType=INTEGER}, #{roleid, jdbcType=INTEGER})"
  })
  int insertUserRoles(Integer userid, Integer roleid);

  @InsertProvider(type = RoleSqlProvider.class, method = "insertSelective")
  int insertSelective(Role record);

  @Select({
    "select",
    "roleid, rolename",
    "from role",
    "where roleid = #{roleid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "roleid", property = "roleid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "rolename", property = "rolename", jdbcType = JdbcType.VARCHAR)
  })
  Role selectByPrimaryKey(Integer roleid);

  @Select({
    "select",
    "roleid, rolename",
    "from role",
    "where rolename = #{rolename, jdbcType=VARCHAR}"
  })
  @Results({
    @Result(column = "roleid", property = "roleid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "rolename", property = "rolename", jdbcType = JdbcType.VARCHAR)
  })
  Role selectByRoleName(String roleName);

  @Select({
    "select",
    "roleid, rolename",
    "from role"
  })
  @Results({
    @Result(column = "roleid", property = "roleid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "rolename", property = "rolename", jdbcType = JdbcType.VARCHAR)
  })
  List<Role> selectAll();

  @Select({
    "select",
    "r.roleid,rolename",
    "from user_role ur",
    "left join role r",
    "on ur.roleid = r.roleid",
    "where userid = #{userid, jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "roleid", property = "roleid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "rolename", property = "rolename", jdbcType = JdbcType.VARCHAR)
  })
  List<Role> selectUserRole(int userid);

  @UpdateProvider(type = RoleSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Role record);

  @Update({
    "update role",
    "set rolename = #{rolename,jdbcType=VARCHAR}",
    "where roleid = #{roleid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Role record);
}