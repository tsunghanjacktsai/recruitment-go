/*
 * This file was automatically generated by EvoSuite
 * Fri Apr 10 11:30:36 GMT 2020
 */

package com.recruit.recruitment.controller;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import com.recruit.recruitment.controller.ResumeController;
import com.recruit.recruitment.model.entity.Result;
import com.recruit.recruitment.model.pojo.Resume;
import com.recruit.recruitment.service.ResumeService;
import com.recruit.recruitment.utils.FormatUtil;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = false, useJEE = true)
public class ResumeController_ESTest extends ResumeController_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      ResumeController resumeController0 = new ResumeController();
      FormatUtil formatUtil0 = mock(FormatUtil.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(formatUtil0).checkObjectNull(any(java.lang.Object[].class));
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "formatUtil", (Object) formatUtil0);
      ResumeService resumeService0 = mock(ResumeService.class, new ViolatedAssumptionAnswer());
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "resumeService", (Object) resumeService0);
      Injector.validateBean(resumeController0, (Class<?>) ResumeController.class);
      Integer integer0 = new Integer(3);
      Result result0 = resumeController0.getResumeByApplicationid(integer0);
      assertEquals(201, (int)result0.getCode());
      assertEquals("No application selected", result0.getMessage());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      ResumeController resumeController0 = new ResumeController();
      FormatUtil formatUtil0 = mock(FormatUtil.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(formatUtil0).checkObjectNull(any(java.lang.Object[].class));
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "formatUtil", (Object) formatUtil0);
      ResumeService resumeService0 = mock(ResumeService.class, new ViolatedAssumptionAnswer());
      doReturn((Resume) null).when(resumeService0).findResumeByApplicationid(anyInt());
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "resumeService", (Object) resumeService0);
      Injector.validateBean(resumeController0, (Class<?>) ResumeController.class);
      Result result0 = resumeController0.getResumeByApplicationid((Integer) null);
      assertEquals(200, (int)result0.getCode());
      assertEquals("Query successful", result0.getMessage());
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      ResumeController resumeController0 = new ResumeController();
      FormatUtil formatUtil0 = mock(FormatUtil.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(formatUtil0).checkObjectNull(any(java.lang.Object[].class));
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "formatUtil", (Object) formatUtil0);
      ResumeService resumeService0 = mock(ResumeService.class, new ViolatedAssumptionAnswer());
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "resumeService", (Object) resumeService0);
      Injector.validateBean(resumeController0, (Class<?>) ResumeController.class);
      Integer integer0 = new Integer(3);
      Result result0 = resumeController0.getResumeByResumeid(integer0);
      assertEquals("Incomplete info", result0.getMessage());
      assertEquals(201, (int)result0.getCode());
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      ResumeController resumeController0 = new ResumeController();
      FormatUtil formatUtil0 = mock(FormatUtil.class, new ViolatedAssumptionAnswer());
      doReturn(true).when(formatUtil0).checkObjectNull(any(java.lang.Object[].class));
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "formatUtil", (Object) formatUtil0);
      ResumeService resumeService0 = mock(ResumeService.class, new ViolatedAssumptionAnswer());
      doReturn((Resume) null).when(resumeService0).findResumeByResumeid(anyInt());
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "resumeService", (Object) resumeService0);
      Injector.validateBean(resumeController0, (Class<?>) ResumeController.class);
      Result result0 = resumeController0.getResumeByResumeid((Integer) null);
      assertEquals(200, (int)result0.getCode());
      assertEquals("Query successful", result0.getMessage());
  }

  @Test(timeout = 4000)
  public void test4()  throws Throwable  {
      ResumeController resumeController0 = new ResumeController();
      FormatUtil formatUtil0 = mock(FormatUtil.class, new ViolatedAssumptionAnswer());
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "formatUtil", (Object) formatUtil0);
      ResumeService resumeService0 = mock(ResumeService.class, new ViolatedAssumptionAnswer());
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "resumeService", (Object) resumeService0);
      Injector.validateBean(resumeController0, (Class<?>) ResumeController.class);
      Result result0 = resumeController0.manageResume((Resume) null, "Resume nofound");
      assertEquals(200, (int)result0.getCode());
      assertEquals("Update successful", result0.getMessage());
  }

  @Test(timeout = 4000)
  public void test5()  throws Throwable  {
      ResumeController resumeController0 = new ResumeController();
      FormatUtil formatUtil0 = mock(FormatUtil.class, new ViolatedAssumptionAnswer());
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "formatUtil", (Object) formatUtil0);
      Resume resume0 = mock(Resume.class, new ViolatedAssumptionAnswer());
      ResumeService resumeService0 = mock(ResumeService.class, new ViolatedAssumptionAnswer());
      doReturn(resume0).when(resumeService0).findResumeByUsername();
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "resumeService", (Object) resumeService0);
      Injector.validateBean(resumeController0, (Class<?>) ResumeController.class);
      Result result0 = resumeController0.getResumeByUserid();
      assertEquals(200, (int)result0.getCode());
      assertEquals("Query successful", result0.getMessage());
  }

  @Test(timeout = 4000)
  public void test6()  throws Throwable  {
      ResumeController resumeController0 = new ResumeController();
      FormatUtil formatUtil0 = mock(FormatUtil.class, new ViolatedAssumptionAnswer());
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "formatUtil", (Object) formatUtil0);
      ResumeService resumeService0 = mock(ResumeService.class, new ViolatedAssumptionAnswer());
      doReturn((List<Resume>) null).when(resumeService0).browseResumes();
      Injector.inject(resumeController0, (Class<?>) ResumeController.class, "resumeService", (Object) resumeService0);
      Injector.validateBean(resumeController0, (Class<?>) ResumeController.class);
      Result result0 = resumeController0.getAllResumes();
      assertEquals("Query succcessful", result0.getMessage());
      assertEquals(200, (int)result0.getCode());
  }
}