package com.techelevator.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCItineraryDAO implements ItineraryDAO{
	
	private JdbcTemplate jdbcTemplate; 
	private SimpleJdbcCall simpleCall;
	
	@Autowired
	public JDBCItineraryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.simpleCall = new SimpleJdbcCall(dataSource);
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
			
			int localId = results.getInt("landmark_id");
			int zip = results.getInt("zipcode");
			String name = results.getString("landmark_name");
			String address = results.getString("address");
			String city = results.getString("city");
			String state = results.getString("state");
			String description = results.getString("description");
			double longitude = results.getDouble("longitude");
			double latitude = results.getDouble("latitude");
			Location local = new Location(localId, zip, name, address, city, state, description, latitude, longitude);
			
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
		
		String queryString = "SELECT * FROM itinerary\n" + 
				"JOIN itinerary_landmarks ON itinerary.itinerary_id = itinerary_landmarks.itinerary_id\n" + 
				"JOIN landmarks ON itinerary_landmarks.landmark_id = landmarks.landmark_id\n" + 
				"WHERE itinerary.user_id = ? AND itinerary.itinerary_id = ?;";
		
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(queryString, userId, itineraryId);
		
		ArrayList<Location> locationList = new ArrayList<Location>();
		
		Itinerary newItin = new Itinerary();
		
		while(results.next()) {
			newItin.setItineraryId(results.getInt("itinerary_id"));
			newItin.setName(results.getString("itinerary_name"));

			
			int zip = results.getInt("zipcode");
			String name = results.getString("landmark_name");
			String address = results.getString("address");
			String city = results.getString("city");
			String state = results.getString("state");
			String description = results.getString("description");
			double longitude = results.getDouble("longitude");
			double latitude = results.getDouble("latitude");
			Location local = new Location(zip, name, address, city, state, description, latitude, longitude);
			locationList.add(local);
		}
		
		newItin.setLocationList(locationList);
		
		return newItin;
	}
	
	public void saveItineraryToDB(int userId, String itinName, ArrayList<Location> localList) {
		
		Itinerary itin = new Itinerary(localList);
		
		itin.setName(itinName);
		
		String queryString = "INSERT INTO itinerary (user_id, itinerary_name)\n" + 
				"VALUES (?,?);";
		
		jdbcTemplate.update(queryString, userId, itinName);
		
		String queryForItinId = "SELECT itinerary_id FROM itinerary WHERE user_id=? AND itinerary_name = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(queryForItinId, userId, itinName);
		
		while(results.next()) {
			itin.setItineraryId(results.getInt("itinerary_id"));
			
			System.out.print(results.getInt("itinerary_id"));
		}
		
		String  updateStringForCrossTable = "INSERT INTO itinerary_landmarks (itinerary_id, landmark_id) VALUES (?,?)";

		ArrayList<Object[]> batchArgs = new ArrayList<Object[]>();
		
		for(Location local: itin.getLocationList()) {
			Integer[] batch = new Integer[]{		
				itin.getItineraryId(),
				local.getLocationId(),
			};
			batchArgs.add(batch);
			}
		jdbcTemplate.batchUpdate(updateStringForCrossTable, batchArgs);
	}

}
