package test.wind.springdemo.test;

import com.wind.springdemo.model.Role;
import com.wind.springdemo.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pc on 2016/2/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml", "classpath:spring-shiro-web.xml"})
public class RoleTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void createRole() {
        Role role = new Role(12, "testrole", "test", Boolean.TRUE);
        roleService.createRole(role);
    }

    @Test
    public void deleteRole() {
        roleService.deleteRole(12);
    }

    @Test
    public void correlationPermissions() {
        roleService.correlationPermissions(2, 12);
    }

    @Test
    public void uncorrelationPermissions() {
        roleService.uncorrelationPermissions(2, 12);
    }

}
