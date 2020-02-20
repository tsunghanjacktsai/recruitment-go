package com.recruit.recruitment.mapper;

import com.recruit.recruitment.model.pojo.Company;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface CompanyMapper {
  @Delete({
    "delete from company",
    "where companyid = #{companyid,jdbcType=INTEGER}"
  })
  int deleteByPrimaryKey(Integer companyid);

  @Insert({
    "insert into company (companyid, companyname)",
    "values (#{companyid,jdbcType=INTEGER}, #{companyname,jdbcType=VARCHAR})"
  })
  int insert(Company record);

  @InsertProvider(type = CompanySqlProvider.class, method = "insertSelective")
  int insertSelective(Company record);

  @Select({
    "select",
    "companyid, companyname",
    "from company",
    "where companyid = #{companyid,jdbcType=INTEGER}"
  })
  @Results({
    @Result(column = "companyid", property = "companyid", jdbcType = JdbcType.INTEGER, id = true),
    @Result(column = "companyname", property = "companyname", jdbcType = JdbcType.VARCHAR)
  })
  Company selectByPrimaryKey(Integer companyid);

  @UpdateProvider(type = CompanySqlProvider.class, method = "updateByPrimaryKeySelective")
  int updateByPrimaryKeySelective(Company record);

  @Update({
    "update company",
    "set companyname = #{companyname,jdbcType=VARCHAR}",
    "where companyid = #{companyid,jdbcType=INTEGER}"
  })
  int updateByPrimaryKey(Company record);
}