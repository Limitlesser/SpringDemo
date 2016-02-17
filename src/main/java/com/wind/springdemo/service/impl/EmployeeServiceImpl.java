package com.wind.springdemo.service.impl;

import com.wind.springdemo.dao.IEmployeeDao;
import com.wind.springdemo.model.Employee;
import com.wind.springdemo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pc on 2016/2/17.
 */
@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeDao employeeDao;

    public int deleteById(Integer id) {
        return employeeDao.deleteById(id);
    }

    public int insert(Employee record) {
        return employeeDao.insert(record);
    }

    public Employee selectById(Integer id) {
        return employeeDao.selectById(id);
    }

    public int updateById(Employee record) {
        return employeeDao.updateById(record);
    }

    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }
}
