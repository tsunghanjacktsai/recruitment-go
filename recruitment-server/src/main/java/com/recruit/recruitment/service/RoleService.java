package com.recruit.recruitment.service;

import com.recruit.recruitment.model.pojo.Role;

import java.util.List;

public interface RoleService {

  /**
   * Find the role by its name
   *
   * @param roleName
   * @return
   */
  Role findRoleByRoleName(String roleName);

  /**
   * Find all roles
   *
   * @return
   */
  List<Role> findAllRoles();
}
