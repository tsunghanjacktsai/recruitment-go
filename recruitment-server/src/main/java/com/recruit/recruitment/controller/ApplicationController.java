package com.recruit.recruitment.controller;

import com.recruit.recruitment.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
  @Autowired
  private ApplicationService applicationService;
}
