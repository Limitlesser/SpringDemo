package com.wind.springdemo.dao;

import com.wind.springdemo.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pc on 2016/2/16.
 */
@Repository
public interface IEmployeeDao {

    int deleteById(Integer id);

    int insert(Employee record);

    Employee selectById(Integer id);

    int updateById(Employee record);

    List<Employee> getAllEmployee();
}
