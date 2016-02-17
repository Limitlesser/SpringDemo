package com.wind.springdemo.service;

import com.wind.springdemo.model.Employee;

import java.util.List;

/**
 * Created by pc on 2016/2/17.
 */
public interface IEmployeeService {

    int deleteById(Integer id);

    int insert(Employee record);

    Employee selectById(Integer id);

    int updateById(Employee record);

    List<Employee> getAllEmployee();
}
