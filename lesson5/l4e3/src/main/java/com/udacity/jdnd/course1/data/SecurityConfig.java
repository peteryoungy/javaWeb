package com.udacity.jdnd.course1.data;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // note: set restricted pages homepage
        http.authorizeRequests()
                // note: 1. users go to /signup, /css, /js do not have to log in
                .antMatchers("/signup", "/css/**", "/js/**").permitAll()
                // note: 2. others have to log in
                .anyRequest().authenticated();

        // note: how to log in? login is handled specially be Spring
        //  generate all the things for us
        //  we can also supply our own if we want to customize
        http.formLogin()
                .loginPage("/login")
                .permitAll();

        // note: default redirect after successful login
        http.formLogin()
                .defaultSuccessUrl("/tacos", true);
    }
}
