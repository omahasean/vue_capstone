package com.techelevator.model;

import java.math.BigDecimal;

public class Location {

	
	private int zipCode;

	private String name;
	
	private String streetAddress;
	
	private String city;
	
	private double longitude;
	
	private double latitude;
	
	private String description;
	
	public Location() {
		// TODO Auto-generated constructor stub
	}

	
	public Location(int zipCode, String name, String streetAddress, String city, double latitude, double longitude) {
		super();
		this.zipCode = zipCode;
		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public double getLongitude() {
		return longitude;
	}


	public double getLatitude() {
		return latitude;
	}


	public String getDescription() {
		return description;
	}


}
