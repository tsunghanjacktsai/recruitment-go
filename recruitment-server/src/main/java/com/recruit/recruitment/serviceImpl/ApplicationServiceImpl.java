package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.config.RabbitMqConfig;
import com.recruit.recruitment.mapper.*;
import com.recruit.recruitment.model.pojo.*;
import com.recruit.recruitment.service.ApplicationService;
import com.recruit.recruitment.service.EvaluatorService;
import com.recruit.recruitment.service.ScoreService;
import com.recruit.recruitment.utils.JwtTokenUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
  @Autowired
  private ApplicationMapper applicationMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private ResumeMapper resumeMapper;

  @Autowired
  private PostMapper postMapper;

  @Autowired
  private ScoreService scoreService;

  @Autowired
  private EvaluatorService evaluatorService;

  @Autowired
  private ScoreMapper scoreMapper;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private HttpServletRequest request;

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Override
  public void addApplicationToPost(Integer postid) {
    Application application = new Application();
    application.setPostid(postid);
    User user = userMapper.selectByUsername(jwtTokenUtil.getUsernameFromRequest(request));
    application.setResumeid(resumeMapper.selectByUserid(user.getUserid()).getResumeid());
    application.setScoreavg(new BigDecimal(0.00, MathContext.DECIMAL64));
    applicationMapper.insertSelective(application);

    String jobName = postMapper.selectByPrimaryKey(postid).getJobname();
    String companyName = postMapper.selectByPrimaryKey(postid).getCompanyname();
    HashMap<String, String> map = new HashMap<>();
    map.put("mail", user.getMail());
    map.put("jobname", jobName);
    map.put("companyname", companyName);
    rabbitTemplate.convertAndSend(RabbitMqConfig.APPLICATION_QUEUE, map);

    Notification notification = new Notification();
    notification.setUserid(user.getUserid());
    notification.setContent("Your application of " + jobName + " at " + companyName + " had been sent");
  }

  @Override
  public void deleteApplication(Integer applicationid) {
    applicationMapper.deleteByPrimaryKey(applicationid);
  }

  @Override
  public boolean checkIfEvaluators(Integer postid) {
    boolean disableApplyButton = false;
    User user = userMapper.selectByUsername(
      jwtTokenUtil.getUsernameFromRequest(request));
    List<String> evaluators = evaluatorService.findEvaluatorsByPostidWithUser(postid);
    for (String evaluator : evaluators) {
      if (evaluator.equals(user.getUsername())) {
        disableApplyButton = true;
      }
    }
    return disableApplyButton;
  }

  @Override
  public boolean checkIfApplied(Integer postid) {
    boolean disableApplyButton = false;
    int userid = userMapper.selectByUsername(
      jwtTokenUtil.getUsernameFromRequest(request)).getUserid();
    int resumeid = resumeMapper.selectByUserid(userid).getResumeid();
    List<Application> applications = applicationMapper.selectByResumeid(resumeid);
    for (Application application : applications) {
      if (postid == application.getPostid()) disableApplyButton = true;
    }
    return disableApplyButton;
  }

  @Override
  public Application findApplicationByApplicationid(Integer applicationid) {
    return applicationMapper.selectByPrimaryKey(applicationid);
  }

  @Override
  public List<Application> findApplicationsByPostid(Integer postid) {
    List<Application> applications = applicationMapper.selectByPostid(postid);
    for (Application application : applications) {
      application.setApplicant(resumeMapper.selectByPrimaryKey(application.getResumeid()).getName());
    }
    applications.sort(Comparator.comparing(Application::getScoreavg).reversed());
    return applications;
  }

  @Override
  public List<Application> findApplicationsByUser() {
    User user = userMapper.selectByUsername(jwtTokenUtil.getUsernameFromRequest(request));
    int resumeid = resumeMapper.selectByUserid(user.getUserid()).getResumeid();
    List<Application> applications = applicationMapper.selectByResumeid(resumeid);
    for (Application application : applications) {
      Post post = postMapper.selectByPrimaryKey(application.getPostid());
      application.setJobname(post.getJobname());
      application.setLocation(post.getLocation());
      application.setCategory(post.getCategory());
    }
    return applications;
  }

  @Override
  public void scoreApplication(Integer applicationid, Integer score) {
    Score scoreByMarker = scoreService.findApplicationScoreByMarker(applicationid);

    if (scoreByMarker.getScoreid() != null) {
      Score newScore = new Score();
      newScore.setScoreid(scoreByMarker.getScoreid());
      newScore.setScore(new BigDecimal(score));
      scoreMapper.updateByPrimaryKeySelective(newScore);
    } else {
      Score newScore = new Score();
      newScore.setMarkerid(userMapper.selectByUsername(
        jwtTokenUtil.getUsernameFromRequest(request)).getUserid());
      newScore.setApplicationid(applicationid);
      newScore.setScore(new BigDecimal(score));
      scoreMapper.insertSelective(newScore);
    }

    try {
      int markerNum = scoreMapper.selectByApplicationid(applicationid).size();
      double scoreavg = applicationMapper.selectByPrimaryKey(applicationid).getScoreavg().doubleValue();
      Application application = new Application();
      application.setApplicationid(applicationid);
      if (scoreByMarker.getScoreid() != null) {
        application.setScoreavg(new BigDecimal(
          (scoreavg * markerNum - scoreByMarker.getScore().doubleValue() + score) / (markerNum)));
      } else {
        application.setScoreavg(new BigDecimal(
          (scoreavg * (markerNum - 1) + score) / (markerNum)));
      }
      applicationMapper.updateByPrimaryKeySelective(application);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
}
