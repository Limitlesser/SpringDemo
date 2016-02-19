package com.wind.springdemo.dao;

import com.wind.springdemo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by pc on 2016/2/16.
 */
public interface UserDao {

    int deleteById(Integer id);

    int insert(User record);

    User selectById(Integer id);

    int updateById(User record);

    List<User> getAllEmployee();

    void correlationRoles(Long userId, Long... roleIds);

    void uncorrelationRoles(Long userId, Long... roleIds);


    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
