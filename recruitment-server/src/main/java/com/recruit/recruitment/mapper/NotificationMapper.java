package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Notification;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface NotificationMapper {
  @Delete({
    "delete from notification",
    "where notificationid = #{notificationid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer notificationid);

  @Insert({
    "insert into notification (notificationid, userid, ",
    "content)",
    "values (#{notificationid,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
    "#{content,jdbcType=VARCHAR})"
  })
  int insert(Notification record);

  @InsertProvider(type = NotificationSqlProvider.class, method = "insertSelective")
  int insertSelective(Notification record);

  @Select({
    "select",
    "max(notificationid)",
    "from notification"
  })
  @ResultType(Integer.class)
  Integer selectByMaxPostid();

  @Select({
    "select",
    "notificationid, userid, content",
    "from notification",
    "where userid = #{userid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "notificationid", property = "notificationid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR)
  })
  List<Notification> selectByUserid(Integer userid);

  @Select({
    "select",
    "notificationid, userid, content",
    "from notification",
    "where notificationid = #{notificationid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "notificationid", property = "notificationid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "userid", property = "userid", jdbcType = JdbcType.INTEGER),
    @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR)
  })
  Notification selectByPrimaryKey(Integer notificationid);

  @UpdateProvider(type = NotificationSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Notification record);

  @Update({
    "update notification",
    "set userid = #{userid,jdbcType=INTEGER},",
    "content = #{content,jdbcType=VARCHAR}",
    "where notificationid = #{notificationid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Notification record);
}