package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.config.RedisConfig;
import com.recruit.recruitment.mapper.ApplicationMapper;
import com.recruit.recruitment.mapper.ResumeMapper;
import com.recruit.recruitment.mapper.UserMapper;
import com.recruit.recruitment.model.pojo.Application;
import com.recruit.recruitment.model.pojo.Job;
import com.recruit.recruitment.model.pojo.Resume;
import com.recruit.recruitment.model.pojo.User;
import com.recruit.recruitment.service.JobService;
import com.recruit.recruitment.service.ResumeService;
import com.recruit.recruitment.utils.JwtTokenUtil;
import com.recruit.recruitment.utils.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
  @Autowired
  ResumeMapper resumeMapper;

  @Autowired
  UserMapper userMapper;

  @Autowired
  ApplicationMapper applicationMapper;

  @Autowired
  JobService jobService;

  @Autowired
  private RequestUtil requestUtil;

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Override
  public void addResume(Resume resume) {
    resumeMapper.insertSelective(resume);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public void updateResume(Resume resume, String jobs) {
    User user = userMapper.selectByUsername(jwtTokenUtil.getUsernameFromRequest(request));
    if (!user.getUserid().equals(resumeMapper.selectByPrimaryKey(resume.getResumeid()).getUserid())) {
      throw new RuntimeException("No Authority");
    }
    resumeMapper.updateByPrimaryKeySelective(resume);
    if (jobs != null) {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      if (jobService.findJobByUserid() != null) {
        jobService.deleteJobByUserid();
      }
      try {
        JSONArray jobArr = new JSONArray(jobs);
        int userid = 0;
        for (int i = 0; i < jobArr.length(); i++) {
          Job job = new Job();
          JSONObject obj = jobArr.getJSONObject(i);
          if (i == 0) userid = obj.getInt("userid");
          job.setUserid(userid);
          if (validateJSONObject(obj, "companyname")) job.setCompanyname(obj.getString("companyname"));
          if (validateJSONObject(obj, "jobtitle")) job.setJobtitle(obj.getString("jobtitle"));
          if (validateJSONObject(obj, "jobstart")) job.setJobstart(formatter.parse(obj.getString("jobstart")));
          if (validateJSONObject(obj, "jobend")) job.setJobend(formatter.parse(obj.getString("jobend")));
          if (validateJSONObject(obj, "jobdescript")) job.setJobdescript(obj.getString("jobdescript"));
          jobService.addJob(job);
        }
      } catch (JSONException | ParseException e) {
        e.printStackTrace();
      }
    } else {
      Job job = new Job();
      job.setUserid(user.getUserid());
      jobService.addJob(job);
    }
  }

  private boolean validateJSONObject(JSONObject obj, String objString) {
    if (obj.optString(objString) != null && obj.optString(objString).length() > 0) {
      return true;
    }
    return false;
  }

  @Override
  public Resume findResumeByResumeid(Integer resumeid) {
    Resume resume = resumeMapper.selectByPrimaryKey(resumeid);
    User user = userMapper.selectByPrimaryKey(resume.getUserid());
    resume.setUsername(user.getUsername());
    return resume;
  }

  @Override
  public Resume findResumeByApplicationid(Integer applicationid) {
    Application application = applicationMapper.selectByPrimaryKey(applicationid);
    Resume resume = resumeMapper.selectByPrimaryKey(application.getResumeid());
    User user = userMapper.selectByPrimaryKey(resume.getUserid());
    resume.setUsername(user.getUsername());
    return resume;
  }

  @Override
  public Resume findResumeByUsername() {
    User user = userMapper.selectByUsername(jwtTokenUtil.getUsernameFromRequest(request));
    Resume resume = resumeMapper.selectByUserid(user.getUserid());
    resume.setUsername(user.getUsername());
    return resume;
  }

  @Override
  public List<Resume> browseResumes() {
    List<Resume> resumes = resumeMapper.selectAll();
    for (Resume resume : resumes) {
      if (resume.getName() == null) {
        resume.setName("Anonymous");
      }
    }
    return resumes;
  }
}
