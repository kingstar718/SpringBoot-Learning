package cn.kingstar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author wujinxing
 * date 2019 2019/4/30 15:51
 * description Spring Security 配置
 */
//@Configuration   //注解这是一个配置类
//@EnableWebSecurity  //注解开启SpringSecurity功能
//@EnableGlobalMethodSecurity(prePostEnabled = true)  //开启Spring Security方法级安全,必须配置()内容才能使@PreAuthorize("hasAnyRole('admin')")生效
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //第二种方式设置加密(推荐)
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //重写config方法  auth对象
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //从内存中进行加载认证信息, 配置了两个用户信息
        /*auth.inMemoryAuthentication().withUser("admin").password("123456").roles();
        auth.inMemoryAuthentication().withUser("user").password("123456").roles();*/
        //不设置加密方式会报如下错误
        //java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"

        //第一种方式设置加密
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("admin"); //controller使用注解实现方法角色控制, 这里必须配置
        //第二种方式加密
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("123456"))
                .roles("user"); //controller使用注解实现方法角色控制, 这里必须配置
    }
}
