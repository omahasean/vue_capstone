package com.techelevator;

import org.junit.Test;

import com.techelevator.model.DistanceCalculator;

public class CoordinateConversionTest {
	
	@Test
	public void convertTwoPointsToMilesTest() {
		DistanceCalculator distCalc = new DistanceCalculator(39.9692, 83.0060, 39.9614, 82.9991, "M");
		
		System.out.println(distCalc.calculateDistance(distCalc.getLat1(), distCalc.getLon1(), distCalc.getLat2(), distCalc.getLon2(), distCalc.getUnitOfMeasure()));
	}
}
