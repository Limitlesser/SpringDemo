package com.wind.springdemo.service;

import com.wind.springdemo.model.Role;

public interface RoleService {


    void createRole(Role role);

    void deleteRole(Integer roleId);

    /**
     * 添加角色-权限之间关系
     *
     * @param roleId
     * @param permissionId
     */
    void correlationPermissions(Integer roleId, Integer permissionId);

    /**
     * 移除角色-权限之间关系
     *
     * @param roleId
     * @param permissionId
     */
    void uncorrelationPermissions(Integer roleId, Integer permissionId);

}
