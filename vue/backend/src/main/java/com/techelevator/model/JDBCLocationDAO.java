package com.techelevator.model;

import java.util.ArrayList;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCLocationDAO implements LocationDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCLocationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Location> retrieveLocationsByZipCode(String zipCode) {
		int zipNumber = Integer.parseInt(zipCode);

		String queryString = "SELECT * FROM Landmarks WHERE zipcode = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(queryString, zipNumber);

		ArrayList<Location> locations = new ArrayList<Location>();

		while (results.next()) {
			int zip = results.getInt("zipcode");
			String name = results.getString("name");
			String address = results.getString("address");
			String city = results.getString("city");
			String state = results.getString("state");
			String description = results.getString("description");
			double longitude = results.getDouble("longitude");
			double latitude = results.getDouble("latitude");
			Location local = new Location(zip, name, address, city, state, description, latitude, longitude);
			locations.add(local);
		}

		return locations;
	}

	public List<Location> getAllLocations() {

		String queryString = "SELECT * FROM Landmarks";

		SqlRowSet results = jdbcTemplate.queryForRowSet(queryString);

		ArrayList<Location> locations = new ArrayList<Location>();

		while (results.next()) {
			int zip = results.getInt("zipcode");
			String name = results.getString("name");
			String address = results.getString("address");
			String city = results.getString("city");
			String state = results.getString("state");
			String description = results.getString("description");
			double longitude = results.getDouble("longitude");
			double latitude = results.getDouble("latitude");
			Location local = new Location(zip, name, address, city, state, description, latitude, longitude);
			locations.add(local);
		}

		return locations;
	}

	@Override
	public List<Location> retrieveLocationsByAddress(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> retrieveLocationsByCityName(String cityName) {
		String queryString = "SELECT * FROM Landmarks WHERE city = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(queryString, cityName);
		ArrayList<Location> locations = new ArrayList<Location>();
		while (results.next()) {

			int zip = results.getInt("zipcode");
			String name = results.getString("name");
			String address = results.getString("address");
			String city = results.getString("city");
			String state = results.getString("state");
			String description = results.getString("description");
			double longitude = results.getDouble("longitude");
			double latitude = results.getDouble("latitude");
			Location local = new Location(zip, name, address, city, state, description, latitude, longitude);
			locations.add(local);
		}

		return locations;
	}

}
