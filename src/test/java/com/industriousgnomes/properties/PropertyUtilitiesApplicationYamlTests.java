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
@ActiveProfiles(profiles={"prod", "yaml"})
public class PropertyUtilitiesApplicationYamlTests {

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
		assertEquals("1.0 OVERRIDE", appVersion);	// Overridden from profile specific YAML file
		assertEquals("J. R. Titko", appAuthor);
	}

	@Test
	public void profileProperties() {
		assertEquals("Prod Environment Properties", envName);
	}
	
	@Test
	public void customerProperties() {
		assertEquals("Joe Smith", customer.getName());
		assertEquals("111 Main St", customer.getStreet().get(0));
		assertEquals("Suite 100", customer.getStreet().get(1));
		assertEquals("Columbus", customer.getCity());
		assertEquals("Ohio", customer.getState());
		assertEquals(null, customer.getZipCode());
	}
}
