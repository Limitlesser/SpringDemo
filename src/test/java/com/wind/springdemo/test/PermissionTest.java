package com.wind.springdemo.test;

import com.wind.springdemo.model.Permission;
import com.wind.springdemo.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pc on 2016/2/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml", "classpath:spring-shiro-web.xml"})
public class PermissionTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void createPermission() {
        Permission permission = new Permission(12, "testpermission", "test", true);
        permissionService.createPermission(permission);
    }

    @Test
    public void deletePermission() {
        permissionService.deletePermission(12);
    }

}
