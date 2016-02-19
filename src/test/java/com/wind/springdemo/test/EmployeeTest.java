package com.wind.springdemo.test;

import com.wind.springdemo.model.User;
import com.wind.springdemo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pc on 2016/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class EmployeeTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
    }

    @Test
    public void insert() {
        User user = new User();
        user.setName("test");
        user.setGender("male");
        user.setAge(0);
        userService.insert(user);
    }

    @Test
    public void selectAll(){
        userService.getAllEmployee();
    }

    @Test
    public void selectById(){
        userService.selectById(1);
    }

    @Test
    public void update(){
        User user = userService.selectById(1);
        user.setName("windddd");
        userService.updateById(user);
    }

    @Test
    public void delete(){
        userService.deleteById(1);
    }

}
