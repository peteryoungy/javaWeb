package com.udacity.jwdnd.c1.review.config;

import com.udacity.jwdnd.c1.review.service.AuthenticationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity   //note: let the Spring know this class is configuring Spring Security
// put our Spring Security Configuration
// using this class to add to Spring security configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationService authenticationService;

    public SecurityConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    //note: configures Spring authentication manager
    protected void configure(AuthenticationManagerBuilder auth) {
        // add use authenticationService to do authentication
        auth.authenticationProvider(this.authenticationService);
    }

    @Override
    // note: defines how Spring receives authorization requests
    //  which pages it requires authorization to access and how it handles log outs
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
                .defaultSuccessUrl("/chat", true);
    }


}