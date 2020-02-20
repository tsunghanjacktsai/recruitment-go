package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Discussion;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface DiscussionMapper {
  @Delete({
    "delete from discussion",
    "where discussionid = #{discussionid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer discussionid);

  @Insert({
    "insert into discussion (discussionid, notificationid, ",
    "senderid, receiverid, ",
    "title, content)",
    "values (#{discussionid,jdbcType=INTEGER}, #{notificationid,jdbcType=INTEGER}, ",
    "#{senderid,jdbcType=INTEGER}, #{receiverid,jdbcType=INTEGER}, ",
    "#{title,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR})"
  })
  int insert(Discussion record);

  @InsertProvider(type = DiscussionSqlProvider.class, method = "insertSelective")
  int insertSelective(Discussion record);

  @Select({
    "select",
    "discussionid, notificationid, senderid, receiverid, title, content",
    "from discussion",
    "where notificationid = #{notificationid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "discussionid", property = "discussionid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "notificationid", property = "notificationid", jdbcType = JdbcType.INTEGER),
    @Result(column = "senderid", property = "senderid", jdbcType = JdbcType.INTEGER),
    @Result(column = "receiverid", property = "receiverid", jdbcType = JdbcType.INTEGER),
    @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
    @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR)
  })
  Discussion selectByNotificationid(Integer notificationid);

  @Select({
    "select",
    "discussionid, notificationid, senderid, receiverid, title, content",
    "from discussion",
    "where discussionid = #{discussionid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "discussionid", property = "discussionid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "notificationid", property = "notificationid", jdbcType = JdbcType.INTEGER),
    @Result(column = "senderid", property = "senderid", jdbcType = JdbcType.INTEGER),
    @Result(column = "receiverid", property = "receiverid", jdbcType = JdbcType.INTEGER),
    @Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
    @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR)
  })
  Discussion selectByPrimaryKey(Integer discussionid);

  @UpdateProvider(type = DiscussionSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Discussion record);

  @Update({
    "update discussion",
    "set notificationid = #{notificationid,jdbcType=INTEGER},",
    "senderid = #{senderid,jdbcType=INTEGER},",
    "receiverid = #{receiverid,jdbcType=INTEGER},",
    "title = #{title,jdbcType=VARCHAR},",
    "content = #{content,jdbcType=VARCHAR}",
    "where discussionid = #{discussionid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Discussion record);
}