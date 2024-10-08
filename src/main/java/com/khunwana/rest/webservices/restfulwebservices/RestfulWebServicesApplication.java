package com.khunwana.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	//cors
	//http://localhost:3000/ to 8080
	//Cross Orgin Request
	//Allow all request only from http://localhost:300/
	
	@Bean
	public WebMvcConfigurer corsConfigurer()
	{
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")  //enbaling mapping for all
					.allowedMethods("*") //specifying all methods are allowes  types of methods POST,GET 
					.allowedOrigins("*");
			}
		};
	}
	
	
	

}
