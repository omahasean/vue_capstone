package com.techelevator;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.model.Itinerary;
import com.techelevator.model.JDBCItineraryDAO;
import com.techelevator.model.JDBCLocationDAO;
import com.techelevator.model.Location;

public class JDBCItineraryDAOTest extends DAOIntegrationTest {

	private JDBCItineraryDAO dao = new JDBCItineraryDAO(super.getDataSource());

	
	@Test
	public void testGetAllItinerariesForUser() {
		Location testLocal1 = new Location(46225, "Lucas Oil Stadium", "500 South Capitol Avenue", "Indianapolis", "Indiana", "Lucas Oil Stadium is a multi-purpose stadium in Downtown Indianapolis, Indiana, United States. It replaced the RCA Dome as the home field of the NFLs Indianapolis Colts and opened on August 16, 2008.[11] The stadium was constructed to allow the removal of the RCA Dome and expansion of the Indiana Convention Center on its site.", 39.76010, 86.16390);
		Location testLocal2 = new Location(44114, "Rock and Roll Hall of Fame","1100 Rock and Roll Boulevard", "Cleveland", "Ohio", "The Rock and Roll Hall of Fame is a museum and hall of fame located in downtown Cleveland, Ohio, on the shore of Lake Erie. The museum documents the history of rock music and the artists, producers, engineers, and other notable figures who have influenced its development.", 41.50850, 81.69540);
		ArrayList<Location> itinTestContents = new ArrayList<Location>();
		itinTestContents.add(testLocal1);
		itinTestContents.add(testLocal2);
		Itinerary testItin = new Itinerary(itinTestContents);
		testItin.setName("test3");
		
		
		ArrayList<Itinerary> expectedItins = (ArrayList<Itinerary>) dao.getAllItinerariesForUser("user");
		
		Itinerary lastItinFromAll = expectedItins.get(2);
		
		Assert.assertTrue(testItin.getName().equals(lastItinFromAll.getName()));
		
		assertItinerariesEqual(lastItinFromAll, testItin);
		
	}
	
	@Test
	public void testGetItinerariesById() {
		Location testLocal1 = new Location(46225, "Lucas Oil Stadium", "500 South Capitol Avenue", "Indianapolis", "Indiana", "Lucas Oil Stadium is a multi-purpose stadium in Downtown Indianapolis, Indiana, United States. It replaced the RCA Dome as the home field of the NFLs Indianapolis Colts and opened on August 16, 2008.[11] The stadium was constructed to allow the removal of the RCA Dome and expansion of the Indiana Convention Center on its site.", 39.76010, 86.16390);
		Location testLocal2 = new Location(44114, "Rock and Roll Hall of Fame","1100 Rock and Roll Boulevard", "Cleveland", "Ohio", "The Rock and Roll Hall of Fame is a museum and hall of fame located in downtown Cleveland, Ohio, on the shore of Lake Erie. The museum documents the history of rock music and the artists, producers, engineers, and other notable figures who have influenced its development.", 41.50850, 81.69540);
		
		ArrayList<Location> itinTestContents = new ArrayList<Location>();
		itinTestContents.add(testLocal1);
		itinTestContents.add(testLocal2);
		Itinerary testItin = new Itinerary(itinTestContents);
		testItin.setName("test3");
		
		Itinerary expectedItin = dao.getItineraryById(3, "user");
		
		Assert.assertTrue(testItin.getName().equals(expectedItin.getName()));
	
		assertItinerariesEqual(expectedItin, testItin);
	}
	
	@Test
	public void testSaveItineraryToDB() {
		Location testLocal1 = new Location(4, 46225, "Lucas Oil Stadium", "500 South Capitol Avenue", "Indianapolis", "Indiana", "Lucas Oil Stadium is a multi-purpose stadium in Downtown Indianapolis, Indiana, United States. It replaced the RCA Dome as the home field of the NFLs Indianapolis Colts and opened on August 16, 2008.[11] The stadium was constructed to allow the removal of the RCA Dome and expansion of the Indiana Convention Center on its site.", 39.76010, 86.16390);
		Location testLocal2 = new Location(5, 44114, "Rock and Roll Hall of Fame","1100 Rock and Roll Boulevard", "Cleveland", "Ohio", "The Rock and Roll Hall of Fame is a museum and hall of fame located in downtown Cleveland, Ohio, on the shore of Lake Erie. The museum documents the history of rock music and the artists, producers, engineers, and other notable figures who have influenced its development.", 41.50850, 81.69540);
		ArrayList<Location> itinTestContents = new ArrayList<Location>();
		itinTestContents.add(testLocal1);
		itinTestContents.add(testLocal2);
		Itinerary testItin = new Itinerary(itinTestContents);
		testItin.setName("test6");
		
		dao.saveItineraryToDB("user", testItin.getName(), testItin.getLocationList());
		
		Itinerary expectedItin = dao.getItineraryById(testItin.getItineraryId(), "user");
		
		assertItinerariesEqual(expectedItin, testItin);
	}
	
	
	
	private void assertItinerariesEqual(Itinerary actual, Itinerary test) {
		ArrayList<Location> actualList = actual.getLocationList();
		ArrayList<Location> testList = test.getLocationList();
		for(int i=0; i<actualList.size(); i++) {
			for(Location t: testList) {
				if(actualList.get(i).getZipCode()==t.getZipCode()) {
					assertLocationsEqual(actualList.get(i), t);
				}
			}
		}
		}
	private void assertLocationsEqual(Location expected, Location actual) {
		Assert.assertTrue("Name not Equal", expected.getName().equals(actual.getName()));
		Assert.assertTrue("City not Equal", expected.getCity().equals(actual.getCity()));
		Assert.assertTrue("Address not Equal", expected.getStreetAddress().equals(actual.getStreetAddress()));
		Assert.assertTrue("Zip not equal", expected.getZipCode()==actual.getZipCode());
	}
}
