package com.khunwana.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.WhiteListedAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	{
		return 
				
		//---authorizing all request
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				)
		//---/authorizing all request
		
		//---showing basic authentication form to prompt login details from user
			.httpBasic(withDefaults())
		//---/showing basic authentication form to prompt login details from user

		//-----------------------------------------------------------------------
		
			
		
		//-----------------------------------------------------------------------
			
		//---/configuring stateless session 
			.sessionManagement(
				session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		)
		
		
		//---disabling csrf
			.csrf().disable()
		//---/disabling csrf
			.cors(withDefaults())
		
		
			.build();
	}
	
	
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().addHeaderWriter(
            new XFrameOptionsHeaderWriter(
                new WhiteListedAllowFromStrategy(Arrays.asList("localhost"))));
    }


}
