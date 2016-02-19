package com.wind.springdemo.service;

import com.wind.springdemo.model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by pc on 2016/2/17.
 */
public interface UserService {

    int deleteById(Integer id);

    int insert(User record);

    User selectById(Integer id);

    int updateById(User record);

    List<User> getAllEmployee();

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleId
     */
    public void correlationRoles(Integer userId, Integer roleId);


    /**
     * 移除用户-角色关系
     * @param userId
     * @param roleId
     */
    public void uncorrelationRoles(Integer userId, Integer roleId);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);

    User findByUsername(String username);
}
