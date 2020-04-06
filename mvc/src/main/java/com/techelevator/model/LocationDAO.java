package com.techelevator.model;

import java.util.List;

public interface LocationDAO {

	public List<Location> retrieveLocationsByZipCode(String zipCode);
	
	public List<Location> retrieveLocationsByAddress(String address);
	
	public List<Location> retrieveLocationsByCityName(String cityName);
	
}
