package com.wind.springdemo.service.impl;

import com.wind.springdemo.dao.PermissionDao;
import com.wind.springdemo.model.Permission;
import com.wind.springdemo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public void createPermission(Permission permission) {
        permissionDao.createPermission(permission);
    }

    public void deletePermission(Integer permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
