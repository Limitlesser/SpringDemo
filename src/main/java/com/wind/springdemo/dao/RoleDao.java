package com.wind.springdemo.dao;

import com.wind.springdemo.model.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {

    void createRole(Role role);

    void deleteRole(Integer roleId);

    void correlationPermission(@Param(value = "role_id") Integer roleId, @Param(value = "permission_id")Integer permissionId);

    void uncorrelationPermission(@Param(value = "role_id")Integer roleId, @Param(value = "permission_id")Integer permissionId);

}
