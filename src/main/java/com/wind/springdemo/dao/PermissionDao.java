package com.wind.springdemo.dao;


import com.wind.springdemo.model.Permission;

public interface PermissionDao {

    Permission createPermission(Permission permission);

    void deletePermission(Integer permissionId);

}
