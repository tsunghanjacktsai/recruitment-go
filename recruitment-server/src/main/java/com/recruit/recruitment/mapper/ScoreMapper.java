package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Score;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ScoreMapper {
  @Delete({
    "delete from score",
    "where scoreid = #{scoreid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer scoreid);

  @Insert({
    "insert into score (scoreid, markerid, ",
    "applicationid, score)",
    "values (#{scoreid,jdbcType=INTEGER}, #{markerid,jdbcType=INTEGER}, ",
    "#{applicationid,jdbcType=INTEGER}, #{score,jdbcType=DECIMAL})"
  })
  int insert(Score record);

  @InsertProvider(type = ScoreSqlProvider.class, method = "insertSelective")
  int insertSelective(Score record);

  @Select({
    "select",
    "scoreid, markerid, applicationid, score",
    "from score",
    "where applicationid = #{applicationid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "scoreid", property = "scoreid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "markerid", property = "markerid", jdbcType = JdbcType.INTEGER),
    @Result(column = "applicationid", property = "applicationid", jdbcType = JdbcType.INTEGER),
    @Result(column = "score", property = "score", jdbcType = JdbcType.DECIMAL)
  })
  List<Score> selectByApplicationid(Integer applicationid);

  @Select({
    "select",
    "scoreid, markerid, applicationid, score",
    "from score",
    "where scoreid = #{scoreid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "scoreid", property = "scoreid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "markerid", property = "markerid", jdbcType = JdbcType.INTEGER),
    @Result(column = "applicationid", property = "applicationid", jdbcType = JdbcType.INTEGER),
    @Result(column = "score", property = "score", jdbcType = JdbcType.DECIMAL)
  })
  Score selectByPrimaryKey(Integer scoreid);

  @UpdateProvider(type = ScoreSqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Score record);

  @Update({
    "update score",
    "set markerid = #{markerid,jdbcType=INTEGER},",
    "applicationid = #{applicationid,jdbcType=INTEGER},",
    "score = #{score,jdbcType=DECIMAL}",
    "where scoreid = #{scoreid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Score record);
}