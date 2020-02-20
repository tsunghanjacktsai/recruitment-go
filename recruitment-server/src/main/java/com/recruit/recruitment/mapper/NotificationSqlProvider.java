package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Notification;
import org.apache.ibatis.jdbc.SQL;

public class NotificationSqlProvider {
  public String insertSelective(Notification record) {
    SQL sql = new SQL();
    sql.INSERT_INTO("notification");

    if (record.getNotificationid() != null) {
      sql.VALUES("notificationid", "#{notificationid,jdbcType=INTEGER}");
    }

    if (record.getUserid() != null) {
      sql.VALUES("userid", "#{userid,jdbcType=INTEGER}");
    }

    if (record.getContent() != null) {
      sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
    }

    return sql.toString();
  }

  public String updateByPrimaryKeySelective(Notification record) {
    SQL sql = new SQL();
    sql.UPDATE("notification");

    if (record.getUserid() != null) {
      sql.SET("userid = #{userid,jdbcType=INTEGER}");
    }

    if (record.getContent() != null) {
      sql.SET("content = #{content,jdbcType=VARCHAR}");
    }

    sql.WHERE("notificationid = #{notificationid,jdbcType=INTEGER}");

    return sql.toString();
  }
}