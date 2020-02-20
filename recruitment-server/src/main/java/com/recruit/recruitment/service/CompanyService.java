package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Company;

public interface CompanyService {
  int addCompany(Company company);

  int deleteCompany(Integer companyid);

  int updateCompany(Company company);

  Company findCompany(Integer companyid);
}
