package com.industriousgnomes.properties;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PropertyUtilitiesApplication.class)
@ActiveProfiles({"dev", "prop"})
public class PropertyUtilitiesApplicationPropTests {

	@Value("${application.name}")
	String appName;
	@Value("${application.version}")
	String appVersion;
	@Value("${application.author}")
	String appAuthor;	
	
	@Value("${environment.name}")
	String envName;

	@Autowired
	Customer customer;
	
	@Test
	public void simpleProperties() {
		assertEquals("YAML Demonstration", appName);
		assertEquals("1.0", appVersion);
		assertEquals("J. R. Titko", appAuthor);
	}

	@Test
	public void profileProperties() {
		assertEquals("Dev Environment Properties", envName);
	}
	
	@Test
	public void customerProperties() {
		assertEquals("Haggard", customer.getName());
		assertEquals("222 High St", customer.getStreet().get(0));
		assertEquals("Apt 123", customer.getStreet().get(1));
		assertEquals("Cincinnati", customer.getCity());
		assertEquals("Ohio", customer.getState());
		assertEquals("43001", customer.getZipCode());
	}
}
