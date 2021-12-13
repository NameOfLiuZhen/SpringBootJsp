package com.h3c.conf;

import com.h3c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /**
         * 制造假的认证用户数据
         *
         *
         * */

//        auth.inMemoryAuthentication()
//                .withUser("zhangsan")
//                .password("{noop}123456")
//                .roles("ADMIN")
//                .and()
//                .withUser("lisi")
//                .password("{noop}123456")
//                .roles("ADMIN");

        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**","/login.jsp","/login")
                .permitAll()
                .anyRequest()
                .authenticated();



        http.formLogin()
                .loginPage("/login.jsp")
                .successForwardUrl("/main.jsp")
                .failureForwardUrl("/login.jsp")
                .loginProcessingUrl("/login")
                .and()
                .csrf()
                .disable();

        http.headers().frameOptions().disable();

    }
}
