package com.wind.springdemo.service.impl;

import com.wind.springdemo.dao.RoleDao;
import com.wind.springdemo.model.Role;
import com.wind.springdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public RoleDao getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public void createRole(Role role) {
         roleDao.createRole(role);
    }

    public void deleteRole(Integer roleId) {
        roleDao.deleteRole(roleId);
    }

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionId
     */
    public void correlationPermissions(Integer roleId, Integer permissionId) {
        roleDao.correlationPermission(roleId, permissionId);
    }

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionId
     */
    public void uncorrelationPermissions(Integer roleId, Integer permissionId) {
        roleDao.uncorrelationPermission(roleId, permissionId);
    }

}
