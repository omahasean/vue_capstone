package com.techelevator.model;

import java.math.BigDecimal;

public class Location {

	
	private int zipCode;

	private String name;
	
	private String streetAddress;
	
	private String city;
	
	private String state;
	
	private double latitude;
	
	private double longitude;
	
	private String description;
	
	private int locationId;

	
	public Location() {
		// TODO Auto-generated constructor stub
	}
	
	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	
	public Location(int zipCode, String name, String streetAddress, String city, String state, String description, double latitude, double longitude) {
		super();
		this.zipCode = zipCode;
		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Location(int locationId, int zipCode, String name, String streetAddress, String city, String state, String description, double latitude, double longitude) {
		super();
		this.locationId = locationId;
		this.zipCode = zipCode;
		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
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


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitutde(double longitude) {
		this.longitude = longitude;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


}
