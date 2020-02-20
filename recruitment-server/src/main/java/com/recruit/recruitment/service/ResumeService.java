package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Job;
import com.recruit.recruitment.model.pojo.Resume;

import java.util.List;

public interface ResumeService {
  void addResume(Resume resume);

  void updateResume(Resume resume, String jobs);

  Resume findResumeByResumeid(Integer resumeid);

  Resume findResumeByApplicationid(Integer applicationid);

  Resume findResumeByUsername();

  List<Resume> browseResumes();
}
