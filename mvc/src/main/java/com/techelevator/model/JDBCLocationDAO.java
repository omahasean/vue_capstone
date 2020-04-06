package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCLocationDAO implements LocationDAO{

	private JdbcTemplate jdbcTemplate;
	
	public JDBCLocationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Location> retrieveLocationsByZipCode(String zipCode) {
		int zipNumber  = Integer.parseInt(zipCode);
		
		String queryString = "SELECT * FROM Landmarks WHERE zipcode = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(queryString, zipNumber);
		
		ArrayList<Location> locations = new ArrayList<Location>();
		
		while(results.next()) {
			int zip = results.getInt("zipcode");
			String name = results.getString("name");
			String address = results.getString("address");
			String city = results.getString("city");
			Location local = new Location(zip, name, address, city);
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
		// TODO Auto-generated method stub
		return null;
	}

	private List<Location> assignValueToLocation(List<Location> list) {
		
		
		return list;
	}
	
}
