package test.wind.springdemo.test;

import com.wind.springdemo.dao.UserDao;
import com.wind.springdemo.model.User;
import com.wind.springdemo.service.UserService;
import com.wind.springdemo.utils.AopTargetUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

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

    @Mock
    private UserDao mockUserDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(AopTargetUtils.getTarget(userService), "userDao", mockUserDao);
    }


    @Test
    public void insert() {
        final User user = new User("test", "test", "male", 0);
        when(mockUserDao.insert(user)).then(new Answer<Integer>() {
            public Integer answer(InvocationOnMock invocationOnMock) throws Throwable {
                user.setId(12);
                return 1;
            }
        });
        userService.insert(user);
        verify(mockUserDao).insert(user);
        assertEquals(12, user.getId().intValue());
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
