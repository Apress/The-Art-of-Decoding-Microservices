package com.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	String str = "hello";

	 
	    @Bean
	    public UserDetailsService userDetailsService(){
	        UserDetails user1 = User.builder()
	                .username("user")
	                .password(bCryptPasswordEncoder().encode("user"))
	                .authorities("ROLE_USER")
	                .build();

	        UserDetails admin = User.builder()
	                .username("admin")
	                .password(bCryptPasswordEncoder().encode("admin"))
	                .authorities("ROLE_ADMIN")
	                .build();

	        return new InMemoryUserDetailsManager(user1,admin);
	    }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	     http
	                .headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
	                .csrf(AbstractHttpConfigurer::disable)
	                .formLogin(AbstractHttpConfigurer::disable)
	                .authorizeHttpRequests(req -> req.requestMatchers("/user/**").hasRole("USER"))
	                .authorizeHttpRequests(req -> req.requestMatchers("/admin/**").hasRole("ADMIN"))
	                .authorizeHttpRequests(req -> req.requestMatchers("/**").hasAnyRole("USER", "ADMIN"))
	                .authorizeHttpRequests(req -> req.anyRequest().authenticated())	                
	                .httpBasic(Customizer.withDefaults());

	        return http.build();
	    }

	    @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder(){
	        return new BCryptPasswordEncoder();
	    }

}
