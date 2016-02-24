package com.wind.springdemo.dao;

import com.wind.springdemo.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by pc on 2016/2/16.
 */
@Repository
public interface UserDao {

    @CacheEvict(value = "user",key = "#id")
    int deleteById(Integer id);

    @CachePut(value = "user",key = "#record.id")
    int insert(User record);

    @Cacheable(value = "user",key = "#id")
    User selectById(Integer id);

    @CachePut(value = "user",key = "#record.id")
    int updateById(User record);

    @Cacheable(value = "user", key = "users")
    List<User> getAllEmployee();

    void correlationRoles(@Param(value = "user_id") Integer userId, @Param(value = "role_id") Integer roleId);

    void uncorrelationRoles(@Param(value = "user_id") Integer userId, @Param(value = "role_id") Integer roleId);


    @Cacheable(value = "user",key = "#username")
    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
