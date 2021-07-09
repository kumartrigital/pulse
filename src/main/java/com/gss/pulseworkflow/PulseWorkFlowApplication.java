package com.gss.pulseworkflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PulseWorkFlowApplication {

	public static void main(String[] args) {
		SpringApplication.run(PulseWorkFlowApplication.class, args);
	}
	/*
	 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)O
	 * .select() .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
	 * .build(); }
	 */
	    
	/*
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurer() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**").allowedOrigins("*"); } }; }
	 */
	
}
