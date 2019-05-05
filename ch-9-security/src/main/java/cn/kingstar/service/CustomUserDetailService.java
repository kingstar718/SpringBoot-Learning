package cn.kingstar.service;

import cn.kingstar.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujinxing
 * date 2019 2019/4/30 16:54
 * description
 */
@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("CustomUserDetailService.loadUserByUsername()");
        //通过username获取信息
        UserInfo userInfo = userInfoService.findByUsername(username);
        if (userInfo==null){
            throw new UsernameNotFoundException("Not Found");
        }

        //定义权限列表
        List<GrantedAuthority> authorities = new ArrayList<>();
        //用户可访问的资源名称
        authorities.add(new SimpleGrantedAuthority("ROLE_"+userInfo.getRole().name()));

        //定义一个User(实现了接口UserDetails)对象, 返回用户的username,password和权限列表
        //定义角色集时, 需要添加前缀"ROLE_"
        //密码需要使用PasswordEncoder进行加密, 否则会报无效的凭证
        User userDetails = new User(userInfo.getUsername(), passwordEncoder.encode(userInfo.getPassword()), authorities);
        return userDetails;
    }
}
