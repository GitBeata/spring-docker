package com.aplikacja.przyklad1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.builders.HttpSecurity;
import org.springframework.security.config.annotation.Configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Konfiguracja zabezpieczeń protokołu http

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // wyłączenie ochrony csrf
                .authorizeRequests()
                .antMachers("/api/users/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginProcessUrl("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

    // Konfiguracja globalna dot. uwierzytelniania
    @Override
    protected void configure(AutenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("password"))
                .roles("USER");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
