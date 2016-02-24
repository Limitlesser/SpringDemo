package com.wind.springdemo.controller;


import com.wind.springdemo.model.User;
import com.wind.springdemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by pc on 2016/2/16.
 */
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login")
    public String login(String name, String password, Model model) {
        String msg;
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                subject.getSession().setAttribute("user", name);
                subject.getSession().setAttribute("role", userService.findRoles(name));
                return "redirect:/users";
            } else {
                return "login";
            }
        } catch (IncorrectCredentialsException e) {
            msg = "Password Wrong. Password for account " + token.getPrincipal() + " was incorrect.";
            model.addAttribute("error", msg);
        } catch (UnknownAccountException e) {
            msg = "Account Doesn't Exist. There is no user with name of " + token.getPrincipal();
            model.addAttribute("error", msg);
        }
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        SecurityUtils.getSubject().logout();
        SecurityUtils.getSubject().getSession().removeAttribute("user");
        SecurityUtils.getSubject().getSession().removeAttribute("role");
        return "login";
    }

    @RequestMapping(value = "/users")
    @RequiresAuthentication
    public String users(HttpServletRequest request) {
        List<User> list = userService.getAllEmployee();
        request.setAttribute("employeeList", list);
        return "index";
    }

    @RequestMapping(value = "/addEmployee")
    @RequiresRoles("boss")
    public String addEmployee(User user) {
        userService.insert(user);
        userService.correlationRoles(user.getId(), 2);
        return "redirect:/users";
    }

    @RequestMapping(value = "/deleteEmployee")
    @RequiresRoles("boss")
    public String deleteEmployee(Integer id) {
        userService.deleteById(id);
        userService.uncorrelationRoles(id, 2);
        return "redirect:/users";
    }

    @RequestMapping(value = "/updateEmployeeUI")
    @RequiresAuthentication
    public String updateEmployeeUI(Integer id, HttpServletRequest request) {
        User user = userService.selectById(id);
        if (!SecurityUtils.getSubject().hasRole("boss") && !SecurityUtils.getSubject().getPrincipal().equals(user.getName())) {
            throw new UnauthorizedException("you can only modify your own info");
        }
        request.setAttribute("user", user);
        return "updateEmployee";
    }

    @RequestMapping(value = "/updateEmployee")
    public String updateEmployee(User user) {
        userService.updateById(user);
        return "redirect:/users";
    }

}

