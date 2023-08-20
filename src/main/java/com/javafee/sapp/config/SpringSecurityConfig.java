package com.javafee.sapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	// Uncomment if the in-memory auth should be applied
	//	@Override
	//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//		User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
	//		auth.inMemoryAuthentication().
	//				withUser(userBuilder.username("Test").password("Test123").roles("ADMIN"));
	//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new MessageDigestPasswordEncoder("SHA-512");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/web/app/**").authenticated()
				.and()
				.formLogin().loginPage("/web/login/login-page")
				.loginProcessingUrl("/authenticateUser")
				.defaultSuccessUrl("/web/app/password/list")
				.permitAll()
				.and()
				.logout()
				.logoutSuccessUrl("/web/login/login-page?logout")
				.permitAll();
	}
}
