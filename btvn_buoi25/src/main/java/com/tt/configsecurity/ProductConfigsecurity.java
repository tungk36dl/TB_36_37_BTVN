package com.tt.configsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class ProductConfigsecurity {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user1 = User
                .withUsername("t1")
                .password(passwordEncoder.encode("123456"))
                .build();
        UserDetails user2 = User
                .withUsername("t2")
                .password(passwordEncoder.encode("123456"))
                .build();
        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        // csrf : cross site request fore : Chống giả mạo request
        httpSecurity.csrf().disable();

        // path không càn uernaem, pasword
        httpSecurity.authorizeRequests().requestMatchers("/register").permitAll();

        // Bất kì request nào cung phải đăng nhập
        httpSecurity.authorizeRequests().anyRequest().authenticated();


        httpSecurity.httpBasic();
        return httpSecurity.build();
    }
}
