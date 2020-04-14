package com.techelevator.model;

import java.util.ArrayList;

public class PackagePost {

	private Location[] itinerary;
	private String username;
	private String itineraryName;
	
	public PackagePost(Location[] itinerary, String username, String itineraryName) {
		this.itinerary = itinerary;
		this.username = username;
		this.itineraryName=itineraryName;
	}
//	public PackagePost(ArrayList<Location> itinerary, String username, String itineraryName) {
//		this.itinerary.setLocationList(itinerary);
//		this.username = username;
//		this.itineraryName=itineraryName;
//	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getItineraryName() {
		return itineraryName;
	}

	public void setItineraryName(String itineraryName) {
		this.itineraryName = itineraryName;
	}
}
