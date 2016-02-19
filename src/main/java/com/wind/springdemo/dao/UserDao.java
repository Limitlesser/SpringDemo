package com.wind.springdemo.dao;

import com.wind.springdemo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by pc on 2016/2/16.
 */
@Repository
public interface UserDao {

    int deleteById(Integer id);

    int insert(User record);

    User selectById(Integer id);

    int updateById(User record);

    List<User> getAllEmployee();

    void correlationRoles(@Param(value = "user_id") Integer userId, @Param(value = "role_id") Integer roleId);

    void uncorrelationRoles(@Param(value = "user_id") Integer userId, @Param(value = "role_id") Integer roleId);


    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
