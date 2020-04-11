/*
 * This file was automatically generated by EvoSuite
 * Thu Apr 09 22:27:59 GMT 2020
 */

package com.recruit.recruitment.serviceImpl;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.shaded.org.mockito.Mockito.*;
import com.recruit.recruitment.mapper.RoleMapper;
import com.recruit.recruitment.model.pojo.Role;
import com.recruit.recruitment.serviceImpl.RoleServiceImpl;
import java.util.List;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.evosuite.runtime.ViolatedAssumptionAnswer;
import org.evosuite.runtime.javaee.injection.Injector;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true, useJEE = true) 
public class RoleServiceImpl_ESTest extends RoleServiceImpl_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test0()  throws Throwable  {
      RoleServiceImpl roleServiceImpl0 = new RoleServiceImpl();
      Role role0 = mock(Role.class, new ViolatedAssumptionAnswer());
      doReturn((String) null).when(role0).toString();
      RoleMapper roleMapper0 = mock(RoleMapper.class, new ViolatedAssumptionAnswer());
      doReturn(role0).when(roleMapper0).selectByRoleName(anyString());
      Injector.inject(roleServiceImpl0, (Class<?>) RoleServiceImpl.class, "roleMapper", (Object) roleMapper0);
      Injector.validateBean(roleServiceImpl0, (Class<?>) RoleServiceImpl.class);
      Role role1 = roleServiceImpl0.findRoleByName("");
      assertNull(role1.getRolename());
  }

  @Test(timeout = 4000)
  public void test1()  throws Throwable  {
      RoleServiceImpl roleServiceImpl0 = new RoleServiceImpl();
      RoleMapper roleMapper0 = mock(RoleMapper.class, new ViolatedAssumptionAnswer());
      doReturn((List<Role>) null).when(roleMapper0).selectAll();
      Injector.inject(roleServiceImpl0, (Class<?>) RoleServiceImpl.class, "roleMapper", (Object) roleMapper0);
      Injector.validateBean(roleServiceImpl0, (Class<?>) RoleServiceImpl.class);
      List<Role> list0 = roleServiceImpl0.findAllRoles();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test2()  throws Throwable  {
      RoleServiceImpl roleServiceImpl0 = new RoleServiceImpl();
      RoleMapper roleMapper0 = mock(RoleMapper.class, new ViolatedAssumptionAnswer());
      doReturn((List) null).when(roleMapper0).selectAll();
      Injector.inject(roleServiceImpl0, (Class<?>) RoleServiceImpl.class, "roleMapper", (Object) roleMapper0);
      Injector.validateBean(roleServiceImpl0, (Class<?>) RoleServiceImpl.class);
      List<Role> list0 = roleServiceImpl0.findAllRoles();
      assertNull(list0);
  }

  @Test(timeout = 4000)
  public void test3()  throws Throwable  {
      RoleServiceImpl roleServiceImpl0 = new RoleServiceImpl();
      RoleMapper roleMapper0 = mock(RoleMapper.class, new ViolatedAssumptionAnswer());
      doReturn((Role) null).when(roleMapper0).selectByRoleName(anyString());
      Injector.inject(roleServiceImpl0, (Class<?>) RoleServiceImpl.class, "roleMapper", (Object) roleMapper0);
      Injector.validateBean(roleServiceImpl0, (Class<?>) RoleServiceImpl.class);
      Role role0 = roleServiceImpl0.findRoleByName("8X^BS),HVQiPQNy}'np");
      assertNull(role0);
  }
}