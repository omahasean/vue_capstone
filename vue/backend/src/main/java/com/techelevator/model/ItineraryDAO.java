package com.techelevator.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface ItineraryDAO {

	public List<Itinerary> getAllItinerariesForUser(String username);
	
	public Itinerary getItineraryById(int ItineraryId, int userId);
	
}
