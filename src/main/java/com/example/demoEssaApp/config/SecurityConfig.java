/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demoEssaApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author LENOVO
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	/** Set a target out-of-security */
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web
				.ignoring()
				// .requestMatchers("/ignore1", "/ignore2");
				.requestMatchers("/webjars/**")
				.requestMatchers("/css/**")
				.requestMatchers("/js/**")
				.requestMatchers("/h2-console/**");
	}

	/** Various security settings */
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests((request) -> request
						// .requestMatchers("/user/**").hasRole("USER")
						// .requestMatchers(HttpMethod.POST, "/user/**").hasRole("ADMIN")
						// .requestMatchers(regexMatcher(".*\\?x=y")).hasRole("SPECIAL") // matches
						// /any/path?x=y
						.requestMatchers("/login").permitAll() // Direct link OK
						.requestMatchers("/user/signup").permitAll()// Direct link OK
						.anyRequest().authenticated() // Otherwise direct link NG
				);
		// Login process
		http
				.formLogin(form -> form
						.loginProcessingUrl("/login") // Login process path
						.loginPage("/login") // Specify login page
						.failureUrl("/login?error") // Transition destination when login fails
						.usernameParameter("userId") // Login page user ID
						.passwordParameter("password") // Login page password
						.defaultSuccessUrl("/user/list", true) // Transition destination after success
				);

		// Disable CSRF measures (temporary)
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		// In-memory authentication
		// The builder will ensure the passwords are encoded before saving in memory
		UserBuilder users = User.builder();
		UserDetails user = users
				.username("user")// add user
				.password(passwordEncoder().encode("user"))
				.roles("GENERAL")
				.build();
		UserDetails admin = users
				.username("admin")// add admin
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
				System.out.println("user ENcode : -------------- "+ passwordEncoder().encode("user"));
				System.out.println("password ENcode : -------------- "+ passwordEncoder().encode("password"));
		return new InMemoryUserDetailsManager(user, admin);
	}

}
