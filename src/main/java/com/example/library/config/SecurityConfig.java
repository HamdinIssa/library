package com.example.library.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    InMemoryUserDetailsManager inMemoryAuthManager() throws Exception {

        // add our users for in memory authentication
        // User.UserBuilder users = User.withDefaultPasswordEncoder();
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        return new InMemoryUserDetailsManager(users.username("merve").password("test123").roles("USER", "ADMIN").build());
    }
//     @Bean
// public PasswordEncoder getPasswordEncoder() {
//     // return NoOpPasswordEncoder.getInstance();
//     return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
// }



    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // http.authorizeRequests()
        //      .anyRequest().authenticated()
        //         .and()
        //         .formLogin()
        //         .loginPage("/login")
        //         .loginProcessingUrl("/index")
        //         .permitAll()
        //         .and()
        //         .logout().permitAll()
        //         .and()
        //         .exceptionHandling().accessDeniedPage("/access-denied");
        // return http.build();
        http.authorizeHttpRequests().anyRequest().authenticated().and()
           .formLogin()
           .loginPage("/login")
           .loginProcessingUrl("/index")
           .permitAll()
           .and()
           .logout().permitAll()
           .and()
           .exceptionHandling().accessDeniedPage("/access-denied");
   return http.build();

    }
}
