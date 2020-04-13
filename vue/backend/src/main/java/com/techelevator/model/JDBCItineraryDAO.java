package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCItineraryDAO implements ItineraryDAO{
	
	private JdbcTemplate jdbcTemplate; 
	
	@Autowired
	public JDBCItineraryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Itinerary> getAllItinerariesForUser(int userId) {
		String queryString = "SELECT * FROM itinerary\n" + 
							"JOIN itinerary_landmarks ON itinerary.itinerary_id = itinerary_landmarks.itinerary_id\n" + 
							"JOIN landmarks ON itinerary_landmarks.landmark_id = landmarks.landmark_id\n" + 
							"WHERE itinerary.user_id = ?;";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(queryString, userId);
		
		ArrayList<Itinerary> itineraryList = new ArrayList<Itinerary>();
		Itinerary firstItin = new Itinerary(1);
		itineraryList.add(firstItin);
		int itineraryCount = 1;
		while(results.next()) {
			int itineraryId = results.getInt("itinerary_id");
			String itineraryName = results.getString("itinerary_name");
			
			int zip = results.getInt("zipcode");
			String name = results.getString("landmark_name");
			String address = results.getString("address");
			String city = results.getString("city");
			String state = results.getString("state");
			String description = results.getString("description");
			double longitude = results.getDouble("longitude");
			double latitude = results.getDouble("latitude");
			Location local = new Location(zip, name, address, city, state, description, latitude, longitude);
			
			for (int i = 0; i<=itineraryList.size(); i++) {
				if(i==(itineraryList.size()) && i!=0 && itineraryId != itineraryList.get(i-1).getItineraryId()) {
					itineraryCount=itineraryId;
					Itinerary newItin = new Itinerary(itineraryCount, itineraryName);
					newItin.addLocationToItinerary(local);
					itineraryList.add(newItin);
					break;
				}
				else if (itineraryId == itineraryList.get(i).getItineraryId()) {
					itineraryList.get(i).addLocationToItinerary(local);
					itineraryList.get(i).setName(itineraryName);
					break;
				}
				else {
					
				}
			}
		}

		return itineraryList;
	}

	@Override
	public Itinerary getItineraryById(int itineraryId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
