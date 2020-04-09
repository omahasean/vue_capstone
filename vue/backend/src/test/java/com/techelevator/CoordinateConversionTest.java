package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.model.DistanceCalculator;
import com.techelevator.model.Location;

public class CoordinateConversionTest {
	
	@Test
	public void convertTwoPointsToMilesTest() {
		DistanceCalculator distCalc = new DistanceCalculator(39.9692, 83.0060, 39.9614, 82.9991, "M");
		
		double distanceExpected = 0.651086973809656;
		
		Assert.assertTrue(distanceExpected == distCalc.calculateDistance(distCalc.getLat1(), distCalc.getLon1(), distCalc.getLat2(), distCalc.getLon2(), "M"));
	}
	
	@Test
	public void convertLocationDataToMilesTest() {
		Location pointA = new Location(43562, "PlaceA", "123 Main St", "Columbus","OH", null, 39.9692, 83.0060);
		Location pointB = new Location(58234, "PlaceB", "421 High St", "Columbus","OH", null, 39.9614, 82.9991);
		
		double distanceExpected = 0.651086973809656;
		
		DistanceCalculator distCalc = new DistanceCalculator(pointA.getLatitude(), pointA.getLongitude(), pointB.getLatitude(), pointB.getLongitude(), "M");
		
		Assert.assertTrue(distanceExpected == distCalc.calculateDistance(distCalc.getLat1(), distCalc.getLon1(), distCalc.getLat2(), distCalc.getLon2(), "M"));
	}
}
