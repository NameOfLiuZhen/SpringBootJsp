package com.h3c.conf;

import com.h3c.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/*
* @EnableGlobalMethodSecurity 为 开启 校验，提前批
* */
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
//                .password("$2a$10$Y3lhZ.Jlep/D854sY5zMt.CvQI4RUetIpDyUUTm5GFMpXyn1xNSgK")
//                .authorities("ROLE_admin","banner:select","banner:delete")
//                .and()
//                .withUser("lisi")
//                .password("$2a$10$Y3lhZ.Jlep/D854sY5zMt.CvQI4RUetIpDyUUTm5GFMpXyn1xNSgK")
////                .roles("ADMIN");
//                .authorities("ROLE_superadmin","banner:delete");

        auth.userDetailsService(userService)
        .passwordEncoder(bCryptPasswordEncoder());
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin/**",
                        "/login.jsp",
                        "/login",
                        "/register.jsp")
                .permitAll()

//                .antMatchers("/test01")
//                .hasAnyRole("ADMIN")
//
//                .antMatchers("/test01")
//                .hasAnyAuthority("banner:select")
//
//                .antMatchers("/test02")
//                .hasAnyAuthority("banner:select")
//
//                .antMatchers("/test03")
//                .hasAnyRole("superadmin")

                .anyRequest()
                .authenticated();



        http.formLogin()
                .loginPage("/login.jsp")
                .successForwardUrl("/admin/login/succ")
                .failureForwardUrl("/admin/login/fail")
                .loginProcessingUrl("/login")
                .and()
                .csrf()
                .disable();

        http.headers().frameOptions().disable();

    }
}
