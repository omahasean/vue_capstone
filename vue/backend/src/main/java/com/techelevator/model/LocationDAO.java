package com.techelevator.model;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public interface LocationDAO {

	public List<Location> retrieveLocationsByZipCode(String zipCode);
	
	public List<Location> retrieveLocationsByAddress(String address);
	
	public List<Location> retrieveLocationsByCityName(String cityName);

	List<Location> getAllLocations();
	
}
