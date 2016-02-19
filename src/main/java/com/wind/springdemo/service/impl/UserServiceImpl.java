package com.wind.springdemo.service.impl;

import com.wind.springdemo.dao.UserDao;
import com.wind.springdemo.model.User;
import com.wind.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by pc on 2016/2/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    public int insert(User record) {
        return userDao.insert(record);
    }

    public User selectById(Integer id) {
        return userDao.selectById(id);
    }

    public int updateById(User record) {
        return userDao.updateById(record);
    }

    public List<User> getAllEmployee() {
        return userDao.getAllEmployee();
    }

    public void correlationRoles(Integer userId, Integer roleId) {
        userDao.correlationRoles(userId, roleId);
    }

    /**
     * 移除用户-角色关系
     *
     * @param userId
     * @param roleId
     */
    public void uncorrelationRoles(Integer userId, Integer roleId) {
        userDao.uncorrelationRoles(userId, roleId);
    }

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    /**
     * 根据用户名查找其角色
     *
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        return userDao.findRoles(username);
    }

    /**
     * 根据用户名查找其权限
     *
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        return userDao.findPermissions(username);
    }
}
