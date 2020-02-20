package com.recruit.recruitment.controller;

import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.entity.StatusCode;
import com.recruit.recruitment.model.pojo.Resume;
import com.recruit.recruitment.service.ResumeService;
import com.recruit.recruitment.utils.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resume")
public class ResumeController {
  @Autowired
  private ResumeService resumeService;

  @Autowired
  private FormatUtil formatUtil;

  @GetMapping("/{resumeid}")
  public Result getResumeByResumeid(@PathVariable Integer resumeid) {
    if (!formatUtil.checkObjectNull(resumeid)) {
      return Result.create(StatusCode.ERROR, "Incomplete info");
    }
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        resumeService.findResumeByResumeid(resumeid));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.NOT_FOUND, "Resume not found");
    }
  }

  @GetMapping("/get-resume-by-applicationid/{applicationid}")
  public Result getResumeByApplicationid(@PathVariable Integer applicationid) {
    if (!formatUtil.checkObjectNull(applicationid)) {
      return Result.create(StatusCode.ERROR, "No application selected");
    }
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        resumeService.findResumeByApplicationid(applicationid));
    } catch (RuntimeException e) {
      return Result.create(StatusCode.NOT_FOUND, "Resume not found");
    }
  }

  @GetMapping("/my-resume")
  public Result getResumeByUserid() {
    try {
      return Result.create(StatusCode.SUCCESS, "Query successful",
        resumeService.findResumeByUsername());
    } catch (RuntimeException e) {
      return Result.create(StatusCode.NOT_FOUND, "Resume not found");
    }
  }

  @GetMapping("/get-all-resumes")
  public Result getAllResumes() {
    try {
      return Result.create(StatusCode.SUCCESS, "Query succcessful",
        resumeService.browseResumes());
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Qeury failed");
    }
  }

  @PreAuthorize("hasAuthority('USER')")
  @PutMapping("/manage-resume/{resumeid}")
  public Result manageResume(Resume resume, @RequestParam(value = "jobs", required = false) String jobs) {
    try {
      resumeService.updateResume(resume, jobs);
      return Result.create(StatusCode.SUCCESS, "Update successful");
    } catch (RuntimeException e) {
      return Result.create(StatusCode.ERROR, "Update failed" + e.getMessage());
    }
  }
}
