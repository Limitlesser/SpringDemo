package com.wind.springdemo.service;


import com.wind.springdemo.model.Permission;

public interface PermissionService {
    Permission createPermission(Permission permission);
    void deletePermission(Integer permissionId);
}
