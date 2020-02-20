package com.recruit.recruitment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.recruit.recruitment"})
@MapperScan("com.recruit.recruitment.mapper")
public class RecruitmentApplication {
  public static void main(String[] args) {
    SpringApplication.run(RecruitmentApplication.class, args);
  }
}
