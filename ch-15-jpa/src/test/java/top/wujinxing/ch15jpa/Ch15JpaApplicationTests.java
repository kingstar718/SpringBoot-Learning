package top.wujinxing.ch15jpa;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.wujinxing.ch15jpa.dao.RoleRepository;
import top.wujinxing.ch15jpa.entity.Role;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Ch15JpaApplicationTests {

    @Autowired
    RoleRepository roleRepository;

    @Test
    public void contextLoads() {
        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.assertNotNull(role.getId());
    }

}
