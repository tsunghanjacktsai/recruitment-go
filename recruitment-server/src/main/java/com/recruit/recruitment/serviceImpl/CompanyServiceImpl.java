package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.model.pojo.Company;
import com.recruit.recruitment.mapper.CompanyMapper;
import com.recruit.recruitment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "companyService")
public class CompanyServiceImpl implements CompanyService {
  @Autowired
  private CompanyMapper companyMapper;

  @Override
  public int addCompany(Company company) {
    return companyMapper.insertSelective(company);
  }

  @Override
  public int deleteCompany(Integer companyid) {
    return companyMapper.deleteByPrimaryKey(companyid);
  }

  @Override
  public int updateCompany(Company company) {
    return companyMapper.updateByPrimaryKeySelective(company);
  }

  @Override
  public Company findCompany(Integer companyid) {
    return companyMapper.selectByPrimaryKey(companyid);
  }
}
