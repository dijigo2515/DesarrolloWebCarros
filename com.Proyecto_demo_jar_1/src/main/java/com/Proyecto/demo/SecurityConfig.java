/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.demo;


import com.Proyecto.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


/**
 *
 * @author maryg
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
    }
    @Bean
    public UserService getUserService(){
    return new UserService();
    }
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    daoAuthenticationProvider.setUserDetailsService(getUserService());
    return daoAuthenticationProvider;
    }
    
    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler(){
      return new  AppAuthenticationSuccessHandler();
    }
    
    public SecurityConfig (UserService userPrincipalDetailsService){
    this.userDetailsService = userPrincipalDetailsService;
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth){
    auth.authenticationProvider(authenticationProvider());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
    
        http.authorizeRequests()
                .antMatchers("/persona","/login","/personasN")
                .hasRole("ADMIN")
                .antMatchers("/persona","/","/login")
                .hasAnyRole("USER","VENDEDOR","ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
<<<<<<< HEAD:com.Proyecto_demo_jar_1/src/main/java/com/Proyecto/demo/SecurityConfig.java
                .loginPage("/login").permitAll().defaultSuccessUrl("/persona",true);
=======
                .loginPage("/login").permitAll().defaultSuccessUrl("/Home.html",true);
>>>>>>> aa30b1a22f56785ecf175e82f372232685c61b76:Proyecto - Copy/src/main/java/com/Proyecto/demo/SecurityConfig.java
    }
}