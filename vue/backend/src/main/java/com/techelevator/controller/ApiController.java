package com.techelevator.controller;

import com.techelevator.authentication.AuthProvider;
import com.techelevator.authentication.UnauthorizedException;
import com.techelevator.model.DistanceCalculator;
import com.techelevator.model.Itinerary;
import com.techelevator.model.ItineraryDAO;
import com.techelevator.model.Location;
import com.techelevator.model.LocationDAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApiController
 */

//@Controller

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AuthProvider authProvider;
    
    @Autowired
    private LocationDAO locationDao;
    
    @Autowired
    private ItineraryDAO itineraryDao;
    
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String authorizedOnly() throws UnauthorizedException {
        /*
        You can lock down which roles are allowed by checking
        if the current user has a role.
        
        In this example, if the user does not have the admin role
        we send back an unauthorized error.
        */
        if (!authProvider.userHasRole(new String[] { "admin" })) {
            throw new UnauthorizedException();
        }
        return "Success";
    }
    
   
	@GetMapping(path="/search/{lat}/{lon}/{radius}", produces = "application/json")
	public List<Location> searchLocations(@PathVariable double lat, @PathVariable double lon, @PathVariable int radius) {	
	
	Location cityCoordinate = new Location(lat, lon);
	//distance from point on map
	int radiusFromPoint = radius;
	
	List<Location> allLocals = locationDao.getAllLocations();
	
	List<Location> refinedList =  new ArrayList<Location>();
	
	for(Location n: allLocals) {
		DistanceCalculator distCalc = new DistanceCalculator(cityCoordinate.getLatitude(), cityCoordinate.getLongitude(), n.getLatitude(), n.getLongitude(), "M");
		if(distCalc.getDistanceBetween()<=radiusFromPoint) {
			refinedList.add(n);
		}
	}
	
		
	return refinedList;
	}
	
	@GetMapping(path="/getUser/{userId}", produces="application/json")
	public List<Itinerary> searchUserItineraries(@PathVariable int userId){
		return itineraryDao.getAllItinerariesForUser(userId);
	}
	@GetMapping(path="/getUserItin/{userId}/{itineraryId}", produces="application/json")
	public Itinerary getItineraryByItineraryId(@PathVariable int userId, @PathVariable int itineraryId){
		return itineraryDao.getItineraryById(itineraryId, userId);
	}
	
}
