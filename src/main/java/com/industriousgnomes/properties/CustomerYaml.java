package com.industriousgnomes.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("Customer")
@ConfigurationProperties(prefix = "customer")
@Profile("yaml")
//@PropertySource(value="classpath:customer.properties", ignoreResourceNotFound=true) // YAML file takes precedence over properties files
//@PropertySource(value="classpath:customer.yaml", ignoreResourceNotFound=true)	// YAML files (other than application.yaml) are not supported in @PropertySource
public class CustomerYaml extends Customer {

	public void setName(String name) {
		super.setName(name);
		log.info("****** From CustomerYaml *******");
		
	}
}
