package top.wujinxing.ch15jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wujinxing.ch15jpa.dao.RoleRepository;
import top.wujinxing.ch15jpa.entity.Role;

/**
 * @author wujinxing
 * date 2019 2019/5/20 15:47
 * description
 */
@RestController
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping("/")
    public String hello(){
        return "hellow";
    }

    @GetMapping("/role")
    public Long index(){
        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        return role.getId();
    }
}
