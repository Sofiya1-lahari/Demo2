package com.javademo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class MySecurityConfig  extends WebSecurityConfigurerAdapter{
    

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MySecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and().formLogin();

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails sofiyaUser = User.builder()
                .username("sofiya")
                .password(passwordEncoder.encode("password"))
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(
                sofiyaUser);
    }
}
