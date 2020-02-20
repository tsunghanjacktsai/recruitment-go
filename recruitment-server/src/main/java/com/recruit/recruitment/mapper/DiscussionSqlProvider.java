package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Discussion;
import org.apache.ibatis.jdbc.SQL;

public class DiscussionSqlProvider {
  public String insertSelective(Discussion record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("discussion");

    if (record.getDiscussionid() != null) {
      sql.VALUES("discussionid", "#{discussionid,jdbcType=INTEGER}");
    }

    if (record.getNotificationid() != null) {
      sql.VALUES("notificationid", "#{notificationid,jdbcType=INTEGER}");
    }

    if (record.getSenderid() != null) {
      sql.VALUES("senderid", "#{senderid,jdbcType=INTEGER}");
    }

    if (record.getReceiverid() != null) {
      sql.VALUES("receiverid", "#{receiverid,jdbcType=INTEGER}");
    }

    if (record.getTitle() != null) {
      sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
    }

    if (record.getContent() != null) {
      sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Discussion record) {
    SQL sql = new SQL();
    sql.UPDATE("discussion");

    if (record.getNotificationid() != null) {
      sql.SET("notificationid = #{notificationid,jdbcType=INTEGER}");
    }

    if (record.getSenderid() != null) {
      sql.SET("senderid = #{senderid,jdbcType=INTEGER}");
    }

    if (record.getReceiverid() != null) {
      sql.SET("receiverid = #{receiverid,jdbcType=INTEGER}");
    }

    if (record.getTitle() != null) {
      sql.SET("title = #{title,jdbcType=VARCHAR}");
    }

    if (record.getContent() != null) {
      sql.SET("content = #{content,jdbcType=VARCHAR}");
    }

    sql.WHERE("discussionid = #{discussionid,jdbcType=INTEGER}");

    return sql.toString();
  }
}