package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Itinerary {

	private ArrayList<Location> locationList;
	private String name;
	private int itineraryId;
	
	
	public Itinerary() {
		
	}
	
	public Itinerary(ArrayList<Location> locationList) {
		this.locationList = locationList;
	}
	public Itinerary (int itineraryId) {
		this.itineraryId=itineraryId;
		this.locationList = new ArrayList<Location>();
	}
	public Itinerary (int itineraryId, String itineraryName) {
		this.itineraryId=itineraryId;
		this.locationList = new ArrayList<Location>();
		this.name = itineraryName;
	}
	
	public Itinerary (int itineraryId, String itineraryName, ArrayList<Location> locationList) {
		this.itineraryId=itineraryId;
		this.locationList = new ArrayList<Location>();
		this.name = itineraryName;
		this.locationList = locationList;
	}

	public ArrayList<Location> getLocationList() {
		return locationList;
	}

	public void setLocationList(ArrayList<Location> locationList) {
		this.locationList = locationList;
	}
	public int getItineraryId() {
		return itineraryId;
	}
	public void setItineraryId(int itineraryId) {
		this.itineraryId = itineraryId;
	}
	
	public void addLocationToItinerary(Location local) {
		locationList.add(local);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
