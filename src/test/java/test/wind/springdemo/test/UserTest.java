package test.wind.springdemo.test;

import com.wind.springdemo.model.User;
import com.wind.springdemo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * Created by pc on 2016/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml", "classpath:spring-shiro-web.xml"})
public class UserTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {
    }


    @Test
    public void insert() {
        User user = new User("test", "test", "male", 0);
        userService.insert(user);
        System.out.print(user.getId());
    }

    @Test
    public void selectAll() {
        List<User> users = userService.getAllEmployee();
        System.out.print(users);
    }

    @Test
    public void selectById() {
        User user = userService.selectById(14);
        System.out.print(user);
    }

    @Test
    public void findByUsername() {
        User user = userService.findByUsername("wind");
        System.out.print(user);
    }

    @Test
    public void update() {
        User user = userService.selectById(14);
        user.setName("windddd");
        userService.updateById(user);
    }

    @Test
    public void correlationRoles() {
        userService.correlationRoles(9, 1);
    }

    @Test
    public void uncorrelationRoles() {
        userService.uncorrelationRoles(9, 1);
    }

    @Test
    public void findRoles() {
        Set<String> roles = userService.findRoles("boss");
        System.out.print(roles);
    }

    @Test
    public void findPermissions() {
        Set<String> permissions = userService.findPermissions("wind");
        System.out.print(permissions);
    }

    @Test
    public void delete() {
        userService.deleteById(12);
    }

}
