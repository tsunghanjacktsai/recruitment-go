package com.recruit.recruitment.serviceImpl;

import com.recruit.recruitment.mapper.RoleMapper;
import com.recruit.recruitment.service.RoleService;
import com.recruit.recruitment.model.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
  @Autowired
  private RoleMapper roleMapper;

  @Override
  public Role findRoleByRoleName(String roleName) {
    return roleMapper.selectByRoleName(roleName);
  }

  @Override
  public List<Role> findAllRoles() {
    return roleMapper.selectAll();
  }
}
