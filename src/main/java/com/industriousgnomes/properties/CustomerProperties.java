package com.industriousgnomes.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("Customer")
@ConfigurationProperties(prefix = "customer")
@Profile("prop")
@PropertySource(value="classpath:customer.properties", ignoreResourceNotFound=true)
public class CustomerProperties extends Customer {
	
	public void setName(String name) {
		super.setName(name);
		log.info("****** From CustomerProperties *******");
		
	}
}
