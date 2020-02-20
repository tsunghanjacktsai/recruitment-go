package com.recruit.recruitment.controller;

import com.recruit.recruitment.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
  @Autowired
  private CompanyService companyService;
}
