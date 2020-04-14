package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface ItineraryDAO {

	public List<Itinerary> getAllItinerariesForUser(String username);
	
	public Itinerary getItineraryById(int ItineraryId, String username);
	
	public void saveItineraryToDB(String username, String itinName, ArrayList<Location> localList);
	
}
