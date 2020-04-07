package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.model.JDBCLocationDAO;
import com.techelevator.model.Location;

public class JDBCLocationsDAOTest  extends DAOIntegrationTest {

	
	private JDBCLocationDAO dao = new JDBCLocationDAO(super.getDataSource());
	
	public JDBCLocationsDAOTest(){
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void retrieveLocationsByZipCodeTest() {
		List<Location> daoList = dao.retrieveLocationsByZipCode("43219");
		
		Location testLocal = new Location(43219, "Easton Town Center", "160 Easton Town Ctr", "Columbus");
		
		assertLocationsEqual(testLocal, daoList.get(0));
		
	}
	
	@Test
	public void getAllLocationsTest() {
		List<Location> daoList = dao.getAllLocations();
		
		Assert.assertEquals(3, daoList.size());
	}
	private void assertLocationsEqual(Location expected, Location actual) {
		Assert.assertTrue("Name not Equal", expected.getName().equals(actual.getName()));
		Assert.assertTrue("City not Equal", expected.getCity().equals(actual.getCity()));
		Assert.assertTrue("Address not Equal", expected.getStreetAddress().equals(actual.getStreetAddress()));
		Assert.assertTrue("Zip not equal", expected.getZipCode()==actual.getZipCode());
	}
}
