/*
 * This file was automatically generated by EvoSuite
 * Fri Apr 10 11:19:57 GMT 2020
 */

package com.recruit.recruitment.serviceImpl;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import static org.evosuite.runtime.EvoAssertions.*;
import com.recruit.recruitment.config.JwtConfig;
import com.recruit.recruitment.mapper.ApplicationMapper;
import com.recruit.recruitment.mapper.PostMapper;
import com.recruit.recruitment.mapper.ResumeMapper;
import com.recruit.recruitment.mapper.ScoreMapper;
import com.recruit.recruitment.mapper.UserMapper;
import com.recruit.recruitment.model.pojo.Application;
import com.recruit.recruitment.model.pojo.Post;
import com.recruit.recruitment.model.pojo.Resume;
import com.recruit.recruitment.model.pojo.Score;
import com.recruit.recruitment.model.pojo.User;
import com.recruit.recruitment.service.ScoreService;
import com.recruit.recruitment.serviceImpl.ApplicationServiceImpl;
import com.recruit.recruitment.utils.JwtTokenUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false, useJEE = true)
public class ApplicationServiceImpl_ESTest extends ApplicationServiceImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ApplicationServiceImpl applicationServiceImpl0 = new ApplicationServiceImpl();
      ApplicationMapper applicationMapper0 = mock(ApplicationMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "applicationMapper", (Object) applicationMapper0);
      JwtTokenUtil jwtTokenUtil0 = mock(JwtTokenUtil.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(jwtTokenUtil0).getUsernameFromRequest(any(javax.servlet.http.HttpServletRequest.class));
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "jwtTokenUtil", (Object) jwtTokenUtil0);
      PostMapper postMapper0 = mock(PostMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "postMapper", (Object) postMapper0);
      RabbitTemplate rabbitTemplate0 = mock(RabbitTemplate.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "rabbitTemplate", (Object) rabbitTemplate0);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "request", (Object) httpServletRequest0);
      ResumeMapper resumeMapper0 = mock(ResumeMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "resumeMapper", (Object) resumeMapper0);
      ScoreMapper scoreMapper0 = mock(ScoreMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreMapper", (Object) scoreMapper0);
      Score score0 = mock(Score.class, new ViolatedAssumptionAnswer());
      doReturn((Integer) null).when(score0).getScoreid();
      ScoreService scoreService0 = mock(ScoreService.class, new ViolatedAssumptionAnswer());
      doReturn(score0).when(scoreService0).findApplicationScoreByMarker(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreService", (Object) scoreService0);
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn((User) null).when(userMapper0).selectByUsername(anyString());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class);
      Integer integer0 = new Integer((-2905));
      Integer integer1 = new Integer(1018);
      // Undeclared exception!
      try { 
        applicationServiceImpl0.scoreApplication(integer0, integer1);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.recruit.recruitment.serviceImpl.ApplicationServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ApplicationServiceImpl applicationServiceImpl0 = new ApplicationServiceImpl();
      ApplicationMapper applicationMapper0 = mock(ApplicationMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "applicationMapper", (Object) applicationMapper0);
      JwtTokenUtil jwtTokenUtil0 = mock(JwtTokenUtil.class, new ViolatedAssumptionAnswer());
      doReturn("Omm6j").when(jwtTokenUtil0).getUsernameFromRequest(any(javax.servlet.http.HttpServletRequest.class));
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "jwtTokenUtil", (Object) jwtTokenUtil0);
      PostMapper postMapper0 = mock(PostMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "postMapper", (Object) postMapper0);
      RabbitTemplate rabbitTemplate0 = mock(RabbitTemplate.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "rabbitTemplate", (Object) rabbitTemplate0);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "request", (Object) httpServletRequest0);
      ResumeMapper resumeMapper0 = mock(ResumeMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "resumeMapper", (Object) resumeMapper0);
      ScoreMapper scoreMapper0 = mock(ScoreMapper.class, new ViolatedAssumptionAnswer());
      doReturn(0).when(scoreMapper0).insertSelective(any(com.recruit.recruitment.model.pojo.Score.class));
      doReturn((List) null).when(scoreMapper0).selectByApplicationid(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreMapper", (Object) scoreMapper0);
      Score score0 = mock(Score.class, new ViolatedAssumptionAnswer());
      doReturn((Integer) null).when(score0).getScoreid();
      ScoreService scoreService0 = mock(ScoreService.class, new ViolatedAssumptionAnswer());
      doReturn(score0).when(scoreService0).findApplicationScoreByMarker(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreService", (Object) scoreService0);
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn((Integer) null).when(user0).getUserid();
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn(user0).when(userMapper0).selectByUsername(anyString());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class);
      Integer integer0 = new Integer(0);
      Integer integer1 = new Integer(40);
      applicationServiceImpl0.scoreApplication(integer0, integer1);
      assertFalse(integer1.equals((Object)integer0));
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ApplicationServiceImpl applicationServiceImpl0 = new ApplicationServiceImpl();
      ApplicationMapper applicationMapper0 = mock(ApplicationMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "applicationMapper", (Object) applicationMapper0);
      JwtTokenUtil jwtTokenUtil0 = mock(JwtTokenUtil.class, new ViolatedAssumptionAnswer());
      doReturn("companyname").when(jwtTokenUtil0).getUsernameFromRequest(any(javax.servlet.http.HttpServletRequest.class));
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "jwtTokenUtil", (Object) jwtTokenUtil0);
      PostMapper postMapper0 = mock(PostMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "postMapper", (Object) postMapper0);
      RabbitTemplate rabbitTemplate0 = mock(RabbitTemplate.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "rabbitTemplate", (Object) rabbitTemplate0);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "request", (Object) httpServletRequest0);
      Resume resume0 = mock(Resume.class, new ViolatedAssumptionAnswer());
      doReturn((Integer) null).when(resume0).getResumeid();
      ResumeMapper resumeMapper0 = mock(ResumeMapper.class, new ViolatedAssumptionAnswer());
      doReturn(resume0).when(resumeMapper0).selectByUserid(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "resumeMapper", (Object) resumeMapper0);
      ScoreMapper scoreMapper0 = mock(ScoreMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreMapper", (Object) scoreMapper0);
      ScoreService scoreService0 = mock(ScoreService.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreService", (Object) scoreService0);
      Integer integer0 = new Integer(1933);
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn(integer0).when(user0).getUserid();
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn(user0).when(userMapper0).selectByUsername(anyString());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class);
      Integer integer1 = new Integer(1);
      // Undeclared exception!
      try { 
        applicationServiceImpl0.checkIfApplied(integer1);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.recruit.recruitment.serviceImpl.ApplicationServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ApplicationServiceImpl applicationServiceImpl0 = new ApplicationServiceImpl();
      ApplicationMapper applicationMapper0 = mock(ApplicationMapper.class, new ViolatedAssumptionAnswer());
      doReturn(0).when(applicationMapper0).insertSelective(any(com.recruit.recruitment.model.pojo.Application.class));
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "applicationMapper", (Object) applicationMapper0);
      JwtTokenUtil jwtTokenUtil0 = mock(JwtTokenUtil.class, new ViolatedAssumptionAnswer());
      doReturn("ILuFcc+").when(jwtTokenUtil0).getUsernameFromRequest(any(javax.servlet.http.HttpServletRequest.class));
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "jwtTokenUtil", (Object) jwtTokenUtil0);
      Post post0 = mock(Post.class, new ViolatedAssumptionAnswer());
      doReturn("VUN\u0005,[PemC!'MqY").when(post0).getJobname();
      Post post1 = mock(Post.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(post1).getCompanyname();
      PostMapper postMapper0 = mock(PostMapper.class, new ViolatedAssumptionAnswer());
      doReturn(post0, post1).when(postMapper0).selectByPrimaryKey(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "postMapper", (Object) postMapper0);
      RabbitTemplate rabbitTemplate0 = mock(RabbitTemplate.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "rabbitTemplate", (Object) rabbitTemplate0);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "request", (Object) httpServletRequest0);
      Integer integer0 = new Integer(734);
      Resume resume0 = mock(Resume.class, new ViolatedAssumptionAnswer());
      doReturn(integer0).when(resume0).getResumeid();
      ResumeMapper resumeMapper0 = mock(ResumeMapper.class, new ViolatedAssumptionAnswer());
      doReturn(resume0).when(resumeMapper0).selectByUserid(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "resumeMapper", (Object) resumeMapper0);
      ScoreMapper scoreMapper0 = mock(ScoreMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreMapper", (Object) scoreMapper0);
      ScoreService scoreService0 = mock(ScoreService.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreService", (Object) scoreService0);
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn("VUN\u0005,[PemC!'MqY").when(user0).getMail();
      doReturn(integer0, integer0).when(user0).getUserid();
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn(user0).when(userMapper0).selectByUsername(anyString());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class);
      applicationServiceImpl0.addApplicationToPost(integer0);
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ApplicationServiceImpl applicationServiceImpl0 = new ApplicationServiceImpl();
      ApplicationMapper applicationMapper0 = mock(ApplicationMapper.class, new ViolatedAssumptionAnswer());
      doReturn((List) null).when(applicationMapper0).selectByPostid(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "applicationMapper", (Object) applicationMapper0);
      JwtTokenUtil jwtTokenUtil0 = new JwtTokenUtil();
      JwtConfig jwtConfig0 = new JwtConfig();
      Injector.inject(jwtTokenUtil0, (Class<?>) JwtTokenUtil.class, "jwtConfig", (Object) jwtConfig0);
      Injector.validateBean(jwtTokenUtil0, (Class<?>) JwtTokenUtil.class);
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "jwtTokenUtil", (Object) jwtTokenUtil0);
      PostMapper postMapper0 = mock(PostMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "postMapper", (Object) postMapper0);
      RabbitTemplate rabbitTemplate0 = new RabbitTemplate((ConnectionFactory) null);
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "rabbitTemplate", (Object) rabbitTemplate0);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "request", (Object) httpServletRequest0);
      ResumeMapper resumeMapper0 = mock(ResumeMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "resumeMapper", (Object) resumeMapper0);
      ScoreMapper scoreMapper0 = mock(ScoreMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreMapper", (Object) scoreMapper0);
      ScoreService scoreService0 = mock(ScoreService.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreService", (Object) scoreService0);
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class);
      Integer integer0 = new Integer(0);
      // Undeclared exception!
      try { 
        applicationServiceImpl0.findApplicationsByPostid(integer0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.recruit.recruitment.serviceImpl.ApplicationServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ApplicationServiceImpl applicationServiceImpl0 = new ApplicationServiceImpl();
      ApplicationMapper applicationMapper0 = mock(ApplicationMapper.class, new ViolatedAssumptionAnswer());
      doReturn(0).when(applicationMapper0).insertSelective(any(com.recruit.recruitment.model.pojo.Application.class));
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "applicationMapper", (Object) applicationMapper0);
      JwtTokenUtil jwtTokenUtil0 = mock(JwtTokenUtil.class, new ViolatedAssumptionAnswer());
      doReturn("ILuFcc+").when(jwtTokenUtil0).getUsernameFromRequest(any(javax.servlet.http.HttpServletRequest.class));
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "jwtTokenUtil", (Object) jwtTokenUtil0);
      Post post0 = mock(Post.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(post0).getJobname();
      PostMapper postMapper0 = mock(PostMapper.class, new ViolatedAssumptionAnswer());
      doReturn(post0, (Post) null).when(postMapper0).selectByPrimaryKey(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "postMapper", (Object) postMapper0);
      RabbitTemplate rabbitTemplate0 = mock(RabbitTemplate.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "rabbitTemplate", (Object) rabbitTemplate0);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "request", (Object) httpServletRequest0);
      Integer integer0 = new Integer(734);
      Integer integer1 = new Integer(734);
      Resume resume0 = mock(Resume.class, new ViolatedAssumptionAnswer());
      doReturn(integer0).when(resume0).getResumeid();
      Resume resume1 = mock(Resume.class, new ViolatedAssumptionAnswer());
      ResumeMapper resumeMapper0 = mock(ResumeMapper.class, new ViolatedAssumptionAnswer());
      doReturn(resume0).when(resumeMapper0).selectByUserid(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "resumeMapper", (Object) resumeMapper0);
      ScoreMapper scoreMapper0 = mock(ScoreMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreMapper", (Object) scoreMapper0);
      ScoreService scoreService0 = mock(ScoreService.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreService", (Object) scoreService0);
      Integer integer2 = new Integer((-4412));
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn(integer2).when(user0).getUserid();
      User user1 = mock(User.class, new ViolatedAssumptionAnswer());
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn(user0).when(userMapper0).selectByUsername(anyString());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class);
      Integer integer3 = new Integer((-4412));
      // Undeclared exception!
      try { 
        applicationServiceImpl0.addApplicationToPost(integer3);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.recruit.recruitment.serviceImpl.ApplicationServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ApplicationServiceImpl applicationServiceImpl0 = new ApplicationServiceImpl();
      Application application0 = mock(Application.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(application0).toString();
      ApplicationMapper applicationMapper0 = mock(ApplicationMapper.class, new ViolatedAssumptionAnswer());
      doReturn(application0).when(applicationMapper0).selectByPrimaryKey(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "applicationMapper", (Object) applicationMapper0);
      JwtTokenUtil jwtTokenUtil0 = mock(JwtTokenUtil.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "jwtTokenUtil", (Object) jwtTokenUtil0);
      PostMapper postMapper0 = mock(PostMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "postMapper", (Object) postMapper0);
      RabbitTemplate rabbitTemplate0 = mock(RabbitTemplate.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "rabbitTemplate", (Object) rabbitTemplate0);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "request", (Object) httpServletRequest0);
      ResumeMapper resumeMapper0 = mock(ResumeMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "resumeMapper", (Object) resumeMapper0);
      ScoreMapper scoreMapper0 = mock(ScoreMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreMapper", (Object) scoreMapper0);
      ScoreService scoreService0 = mock(ScoreService.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreService", (Object) scoreService0);
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class);
      Integer integer0 = new Integer(3735);
      Application application1 = applicationServiceImpl0.findApplicationByApplicationid(integer0);
      assertEquals(0, (int)application1.getApplicationid());
  }

  @Test(timeout = 4000)
  public void test7()  throws Throwable  {
      ApplicationServiceImpl applicationServiceImpl0 = new ApplicationServiceImpl();
      ApplicationMapper applicationMapper0 = mock(ApplicationMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "applicationMapper", (Object) applicationMapper0);
      JwtTokenUtil jwtTokenUtil0 = mock(JwtTokenUtil.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(jwtTokenUtil0).getUsernameFromRequest(any(javax.servlet.http.HttpServletRequest.class));
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "jwtTokenUtil", (Object) jwtTokenUtil0);
      PostMapper postMapper0 = mock(PostMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "postMapper", (Object) postMapper0);
      RabbitTemplate rabbitTemplate0 = mock(RabbitTemplate.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "rabbitTemplate", (Object) rabbitTemplate0);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "request", (Object) httpServletRequest0);
      ResumeMapper resumeMapper0 = mock(ResumeMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "resumeMapper", (Object) resumeMapper0);
      ScoreMapper scoreMapper0 = mock(ScoreMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreMapper", (Object) scoreMapper0);
      ScoreService scoreService0 = mock(ScoreService.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreService", (Object) scoreService0);
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn((User) null).when(userMapper0).selectByUsername(anyString());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class);
      // Undeclared exception!
      try { 
        applicationServiceImpl0.findApplicationsByUser();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.recruit.recruitment.serviceImpl.ApplicationServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test8()  throws Throwable  {
      ApplicationServiceImpl applicationServiceImpl0 = new ApplicationServiceImpl();
      ApplicationMapper applicationMapper0 = mock(ApplicationMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "applicationMapper", (Object) applicationMapper0);
      JwtTokenUtil jwtTokenUtil0 = mock(JwtTokenUtil.class, new ViolatedAssumptionAnswer());
      doReturn("").when(jwtTokenUtil0).getUsernameFromRequest(any(javax.servlet.http.HttpServletRequest.class));
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "jwtTokenUtil", (Object) jwtTokenUtil0);
      PostMapper postMapper0 = mock(PostMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "postMapper", (Object) postMapper0);
      RabbitTemplate rabbitTemplate0 = mock(RabbitTemplate.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "rabbitTemplate", (Object) rabbitTemplate0);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "request", (Object) httpServletRequest0);
      Resume resume0 = mock(Resume.class, new ViolatedAssumptionAnswer());
      doReturn((Integer) null).when(resume0).getResumeid();
      ResumeMapper resumeMapper0 = mock(ResumeMapper.class, new ViolatedAssumptionAnswer());
      doReturn(resume0).when(resumeMapper0).selectByUserid(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "resumeMapper", (Object) resumeMapper0);
      ScoreMapper scoreMapper0 = mock(ScoreMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreMapper", (Object) scoreMapper0);
      ScoreService scoreService0 = mock(ScoreService.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreService", (Object) scoreService0);
      Integer integer0 = new Integer(309);
      User user0 = mock(User.class, new ViolatedAssumptionAnswer());
      doReturn(integer0).when(user0).getUserid();
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      doReturn(user0).when(userMapper0).selectByUsername(anyString());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class);
      // Undeclared exception!
      try { 
        applicationServiceImpl0.findApplicationsByUser();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         verifyException("com.recruit.recruitment.serviceImpl.ApplicationServiceImpl", e);
      }
  }

  @Test(timeout = 4000)
  public void test9()  throws Throwable  {
      ApplicationServiceImpl applicationServiceImpl0 = new ApplicationServiceImpl();
      ApplicationMapper applicationMapper0 = mock(ApplicationMapper.class, new ViolatedAssumptionAnswer());
      doReturn(219).when(applicationMapper0).deleteByPrimaryKey(anyInt());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "applicationMapper", (Object) applicationMapper0);
      JwtTokenUtil jwtTokenUtil0 = mock(JwtTokenUtil.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "jwtTokenUtil", (Object) jwtTokenUtil0);
      PostMapper postMapper0 = mock(PostMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "postMapper", (Object) postMapper0);
      RabbitTemplate rabbitTemplate0 = mock(RabbitTemplate.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "rabbitTemplate", (Object) rabbitTemplate0);
      HttpServletRequest httpServletRequest0 = mock(HttpServletRequest.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "request", (Object) httpServletRequest0);
      ResumeMapper resumeMapper0 = mock(ResumeMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "resumeMapper", (Object) resumeMapper0);
      ScoreMapper scoreMapper0 = mock(ScoreMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreMapper", (Object) scoreMapper0);
      Integer integer0 = new Integer(3430);
      ScoreService scoreService0 = mock(ScoreService.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "scoreService", (Object) scoreService0);
      UserMapper userMapper0 = mock(UserMapper.class, new ViolatedAssumptionAnswer());
      Injector.inject(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class, "userMapper", (Object) userMapper0);
      Injector.validateBean(applicationServiceImpl0, (Class<?>) ApplicationServiceImpl.class);
      applicationServiceImpl0.deleteApplication(integer0);
  }
}