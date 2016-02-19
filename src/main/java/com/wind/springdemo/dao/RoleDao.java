package com.wind.springdemo.dao;

import com.wind.springdemo.model.Role;


public interface RoleDao {

    Role createRole(Role role);

    void deleteRole(Long roleId);

    void correlationPermissions(Long roleId, Long... permissionIds);

    void uncorrelationPermissions(Long roleId, Long... permissionIds);

}
