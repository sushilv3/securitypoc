package com.kodecamp.securitypoc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		//overwrite default in memory basicAuthenticationFilter userDetails (userName and password)
		InMemoryUserDetailsManager ud = new InMemoryUserDetailsManager();
		
		//use userBuilder
		UserDetails user= User.withUsername("sushil").password("123").authorities("read").build();
		
		ud.createUser(user);
		
		return ud;
	}
	
	//for row password
	@Bean
	public PasswordEncoder passwordEncoder() { 
		return NoOpPasswordEncoder.getInstance();
	}

}
