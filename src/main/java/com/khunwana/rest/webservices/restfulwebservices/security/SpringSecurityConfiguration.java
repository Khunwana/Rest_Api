package com.khunwana.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	{
		
		//---authorizing all request
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
		//---/authorizing all request
		
		//---showing basic authentication form to prompt login details from user
		http.httpBasic(withDefaults());
		//---/showing basic authentication form to prompt login details from user
		
		//---disabling csrf
		http.csrf().disable();
		//---/disabling csrf
		http.cors(withDefaults());
		
		
		return http.build();
	}

}
