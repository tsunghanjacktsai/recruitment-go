/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Fri Apr 10 13:02:21 GMT 2020
 */

package com.recruit.recruitment.config;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

import static org.evosuite.shaded.org.mockito.Mockito.*;
@EvoSuiteClassExclude
public class WebMvcConfig_ESTest_scaffolding {

  @org.junit.Rule 
  public org.evosuite.runtime.vnet.NonFunctionalRequirementRule nfr = new org.evosuite.runtime.vnet.NonFunctionalRequirementRule();

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);


  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "com.recruit.recruitment.config.WebMvcConfig"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init();
    setSystemProperties();
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    try { initMocksToAvoidTimeoutsInTheTests(); } catch(ClassNotFoundException e) {} 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public static void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("file.encoding", "MS950"); 
    java.lang.System.setProperty("java.awt.headless", "true"); 
    java.lang.System.setProperty("java.io.tmpdir", "C:\\Users\\Jack\\AppData\\Local\\Temp\\"); 
    java.lang.System.setProperty("user.country", "TW"); 
    java.lang.System.setProperty("user.dir", "C:\\Users\\Jack\\Documents\\Java\\recruitment-go\\recruitment-server"); 
    java.lang.System.setProperty("user.home", "C:\\Users\\Jack"); 
    java.lang.System.setProperty("user.language", "zh"); 
    java.lang.System.setProperty("user.name", "Jack"); 
    java.lang.System.setProperty("user.timezone", "Europe/London"); 
  }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(WebMvcConfig_ESTest_scaffolding.class.getClassLoader() ,
      "org.springframework.beans.factory.HierarchicalBeanFactory",
      "org.springframework.core.Ordered",
      "org.springframework.web.context.ServletContextAware",
      "org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer",
      "org.springframework.validation.Validator",
      "org.springframework.web.servlet.config.annotation.ViewControllerRegistry",
      "org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration",
      "org.springframework.beans.factory.Aware",
      "org.springframework.context.support.ApplicationObjectSupport",
      "org.springframework.web.servlet.handler.AbstractHandlerMapping",
      "org.springframework.web.servlet.config.annotation.CorsRegistry",
      "org.springframework.beans.factory.BeanInitializationException",
      "org.springframework.web.servlet.config.annotation.InterceptorRegistry",
      "org.springframework.core.env.EnvironmentCapable",
      "org.springframework.context.ApplicationEventPublisher",
      "org.springframework.web.accept.MediaTypeFileExtensionResolver",
      "org.springframework.validation.MessageCodesResolver",
      "org.springframework.lang.Nullable",
      "org.springframework.beans.factory.BeanNameAware",
      "org.springframework.web.servlet.handler.SimpleUrlHandlerMapping",
      "org.springframework.context.MessageSource",
      "org.springframework.web.servlet.config.annotation.PathMatchConfigurer",
      "org.springframework.core.NestedRuntimeException",
      "org.springframework.web.context.support.WebApplicationObjectSupport",
      "org.springframework.format.FormatterRegistry",
      "org.springframework.core.io.ResourceLoader",
      "org.springframework.beans.FatalBeanException",
      "org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer",
      "org.springframework.web.servlet.handler.MatchableHandlerMapping",
      "org.springframework.web.servlet.handler.AbstractUrlHandlerMapping",
      "org.springframework.core.convert.converter.ConverterRegistry",
      "org.springframework.beans.BeansException",
      "org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry",
      "org.springframework.context.ApplicationContext",
      "org.springframework.context.annotation.Configuration",
      "org.springframework.stereotype.Component",
      "org.springframework.web.accept.ContentNegotiationStrategy",
      "com.recruit.recruitment.config.WebMvcConfig",
      "org.springframework.web.servlet.HandlerMapping",
      "org.springframework.web.servlet.config.annotation.ViewResolverRegistry",
      "org.springframework.beans.factory.BeanFactory",
      "org.springframework.web.util.UrlPathHelper",
      "org.springframework.web.accept.ContentNegotiationManager",
      "org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer",
      "org.springframework.core.io.support.ResourcePatternResolver",
      "org.springframework.web.servlet.config.annotation.WebMvcConfigurer",
      "org.springframework.context.ApplicationContextAware",
      "org.springframework.beans.factory.ListableBeanFactory"
    );
  } 
  private static void initMocksToAvoidTimeoutsInTheTests() throws ClassNotFoundException { 
    mock(Class.forName("org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry", false, WebMvcConfig_ESTest_scaffolding.class.getClassLoader()));
  }

  private static void resetClasses() {
    org.evosuite.runtime.classhandling.ClassResetter.getInstance().setClassLoader(WebMvcConfig_ESTest_scaffolding.class.getClassLoader()); 

    org.evosuite.runtime.classhandling.ClassStateSupport.resetClasses(
      "com.recruit.recruitment.config.WebMvcConfig",
      "org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry",
      "org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration"
    );
  }
}