package com.wind.springdemo.dao;


import com.wind.springdemo.model.Permission;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao {

    void createPermission(Permission permission);

    void deletePermission(Integer permissionId);

}
