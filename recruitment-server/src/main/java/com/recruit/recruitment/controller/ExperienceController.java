package com.recruit.recruitment.controller;

import com.recruit.recruitment.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienceController {
  @Autowired
  private ExperienceService experienceService;
}
