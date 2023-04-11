package com.techmaster.security1.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/").permitAll()
                .requestMatchers("/dash-board").hasAnyRole("ADMIN","SALE")
                .requestMatchers("/user").hasRole("ADMIN")
                .requestMatchers("/category").hasAnyRole("ADMIN","SALE")
                .requestMatchers("/product").hasAnyRole("ADMIN","SALE")
                .requestMatchers("/brand").hasAnyRole("ADMIN","SALE")
                .requestMatchers("/order").hasAnyRole("ADMIN","SALE")
                .requestMatchers("/post").hasAnyRole("ADMIN","SALE","AUTHOR")
                .requestMatchers("/user-info").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl("/",true)
                .and()
                .logout()
                .logoutSuccessUrl("/");
        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("0")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("0")
                .roles("USER","ADMIN")
                .build();
        UserDetails author = User.withDefaultPasswordEncoder()
                .username("author")
                .password("0")
                .roles("AUTHOR")
                .build();
        return new InMemoryUserDetailsManager(user,admin,author);
    }
}
