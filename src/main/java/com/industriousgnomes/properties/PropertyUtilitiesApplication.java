package com.industriousgnomes.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class PropertyUtilitiesApplication {

	private static final Logger log = LoggerFactory.getLogger(PropertyUtilitiesApplication.class);
	
	@Value("${application.name}")
	String appName;
	
	@Value("${environment.name}")
	String envName;
	
	@Bean
	public CommandLineRunner yamlProperties() {
		return(evt) -> {
			log.info("*****************");
			log.info("Application Name: " + appName);
			log.info("Environment Name: " + envName);
			log.info("*****************");
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PropertyUtilitiesApplication.class, args);
	}
}
