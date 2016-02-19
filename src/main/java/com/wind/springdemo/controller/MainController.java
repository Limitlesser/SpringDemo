package com.wind.springdemo.controller;


import com.wind.springdemo.model.User;
import com.wind.springdemo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
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
        UsernamePasswordToken token = new UsernamePasswordToken(name, new String(password.getBytes(), Charset.defaultCharset()));
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                return "redirect:/users";
            } else {
                return "login";
            }
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
            model.addAttribute("error", msg);
            System.out.println(msg);
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多";
            model.addAttribute("error", msg);
            System.out.println(msg);
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
            model.addAttribute("error", msg);
            System.out.println(msg);
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
            model.addAttribute("error", msg);
            System.out.println(msg);
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
            model.addAttribute("error", msg);
            System.out.println(msg);
        } catch (UnknownAccountException e) {
            msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
            model.addAttribute("error", msg);
            System.out.println(msg);
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
            model.addAttribute("error", msg);
            System.out.println(msg);
        }
        return "login";
    }

    @RequestMapping(value = "/users")
    public String users(HttpServletRequest request) {
        List<User> list = userService.getAllEmployee();
        request.setAttribute("employeeList", list);
        return "index";
    }

    @RequestMapping(value = "addEmployeeUI")
    public String addEmployeeUI(){
        SecurityUtils.getSubject().checkRole("boss");
        return "addEmployee";
    }

    @RequestMapping(value = "/addEmployee")
    public String addEmployee(User user) {
        SecurityUtils.getSubject().checkRole("boss");
        userService.insert(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/deleteEmployee")
    public String deleteEmployee(Integer id) {
        SecurityUtils.getSubject().checkRole("boss");
        userService.deleteById(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/updateEmployeeUI")
    public String updateEmployeeUI(Integer id, HttpServletRequest request) {
        User user = userService.selectById(id);
        if(!SecurityUtils.getSubject().hasRole("boss")&&!SecurityUtils.getSubject().getPrincipal().equals(user.getName())){
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

