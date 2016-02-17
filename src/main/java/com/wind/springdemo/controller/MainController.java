package com.wind.springdemo.controller;


import com.wind.springdemo.model.Employee;
import com.wind.springdemo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by pc on 2016/2/16.
 */
@Controller
public class MainController {

    @Autowired
    private IEmployeeService mEmployeeService;

    @RequestMapping(value = "/")
    public String listEmployee(HttpServletRequest request) {
        List<Employee> list = mEmployeeService.getAllEmployee();
        request.setAttribute("employeeList", list);
        return "index";
    }

    @RequestMapping(value = "/addEmployee")
    public String addEmployee(Employee employee) {
        mEmployeeService.insert(employee);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteEmployee")
    public String deleteEmployee(Integer id) {
        mEmployeeService.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/updateEmployeeUI")
    public String updateEmployeeUI(Integer id, HttpServletRequest request) {
        Employee employee = mEmployeeService.selectById(id);
        request.setAttribute("employee", employee);
        return "updateEmployee";
    }

    @RequestMapping(value = "/updateEmployee")
    public String updateEmployee(Employee employee) {
        mEmployeeService.updateById(employee);
        return "redirect:/";
    }

}

