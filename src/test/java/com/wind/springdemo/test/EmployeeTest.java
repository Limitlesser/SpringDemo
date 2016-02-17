package com.wind.springdemo.test;

import com.wind.springdemo.model.Employee;
import com.wind.springdemo.service.IEmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pc on 2016/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class EmployeeTest {

    @Autowired
    private IEmployeeService employeeService;

    @Before
    public void setUp() {
    }

    @Test
    public void insert() {
        Employee employee = new Employee();
        employee.setName("test");
        employee.setGender("male");
        employee.setAge(0);
        employeeService.insert(employee);
    }

    @Test
    public void selectAll(){
        employeeService.getAllEmployee();
    }

    @Test
    public void selectById(){
        employeeService.selectById(1);
    }

    @Test
    public void update(){
        Employee employee = employeeService.selectById(1);
        employee.setName("windddd");
        employeeService.updateById(employee);
    }

    @Test
    public void delete(){
        employeeService.deleteById(1);
    }

}
