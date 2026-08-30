package com.project.dcl.config;



import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppConfig {
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
	
//	@Bean
//	public AuthenticationManager authManager(AuthenticationConfiguration config) {
//		return config.getAuthenticationManager();
//		
//	}
//	
	
	
	

	//SecurityFilterChain will help us in customising te security for those which has to private nd public
	@Bean
	SecurityFilterChain configureSecurity(HttpSecurity security) {
		security.csrf(csrf -> csrf.disable()).authorizeHttpRequests(req->req.requestMatchers("/user/register",
	              "/v3/api-docs/**", // Swagger API documentation
	              "/swagger-ui/**",
	              "/swagger-ui.html" )
		.permitAll()//.permitall is used to permit to public request and authenticated for verifying 
		.anyRequest()//other req
		.authenticated());//secured the other req that must be authenticated
		//.formLogin(Customizer.withDefaults());//default login page permitted automatic accesss
		
		return security.build();
		//creates a refernce obj for filter chain
		
	}
}
