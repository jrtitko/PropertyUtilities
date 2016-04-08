package com.industriousgnomes.properties;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {

	protected static final Logger log = LoggerFactory.getLogger(CustomerProperties.class);
	
	private String name;
	private List<String> street;
	private String city;
	private String state;
	private String zipCode;

	public Customer() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		log.info("****** NAME SET ******");
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<String> getStreet() {
		return street;
	}

	public void setStreet(List<String> street) {
		this.street = street;
	}

}