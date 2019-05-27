package top.wujinxing.ch15jpa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import top.wujinxing.ch15jpa.config.JpaConfiguration;
import top.wujinxing.ch15jpa.dao.RoleRepository;
import top.wujinxing.ch15jpa.dao.UserRepository;
import top.wujinxing.ch15jpa.entity.Role;

/**
 * @author wujinxing
 * date 2019 2019/5/20 15:31
 * description
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class MyTest {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void test(){
        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.assertNotNull(role.getId());
    }

}
