package com.javaschool.SBB.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password(passwordEncoder().encode("1234")).roles("EMPLOYEE")
                .and()
                .withUser("user2").password(passwordEncoder().encode("1234")).roles("EMPLOYEE")
                .and()
                .withUser("admin").password(passwordEncoder().encode("1111")).roles("ADMIN");


       /* auth.jdbcAuthentication()
                .dataSource(dataSource).
                usersByUsernameQuery("SELECT username, password, enabled"
                + " FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, role "
                        + "FROM users WHERE username = ?")
                .passwordEncoder(passwordEncoder());
        */
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and().formLogin()
                .and()
                .formLogin()
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/", true)
                .failureUrl("/login.html?error=true")
                .and()
                .logout()
                .logoutUrl("/performLogOut")
                .logoutSuccessUrl("/");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
