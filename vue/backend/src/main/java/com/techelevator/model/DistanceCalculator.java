package com.techelevator.model;

import java.util.*;
import java.lang.*;
import java.io.*;

public class DistanceCalculator {

	private double lat1;
	private double lon1;
	private double lat2;
	private double lon2;
	//where "K" is Kilometers and "N" is Nautical Miles.
	private String unitOfMeasure;
	
	private double distanceBetween;


	public DistanceCalculator(double lat1, double lon1, double lat2, double lon2, String unitOfMeasure) {
		super();
		this.lat1 = lat1;
		this.lon1 = lon1;
		this.lat2 = lat2;
		this.lon2 = lon2;
		this.unitOfMeasure = unitOfMeasure;	
		this.distanceBetween = calculateDistance(lat1, lon1, lat2, lon2, unitOfMeasure);
	}

	
	private double calculateDistance(double lat1, double lon1, double lat2, double lon2, String unit) {
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		} else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
					+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}


	public double getLat1() {
		return lat1;
	}


	public double getLon1() {
		return lon1;
	}


	public double getLat2() {
		return lat2;
	}


	public double getLon2() {
		return lon2;
	}


	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public double getDistanceBetween() {
		return distanceBetween;
	}
}



/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::                                                                         :*/
/*::  This routine calculates the distance between two points (given the     :*/
/*::  latitude/longitude of those points). It is being used to calculate     :*/
/*::  the distance between two locations using GeoDataSource (TM) products   :*/
/*::                                                                         :*/
/*::  Definitions:                                                           :*/
/*::    Southern latitudes are negative, eastern longitudes are positive     :*/
/*::                                                                         :*/
/*::  Function parameters:                                                   :*/
/*::    lat1, lon1 = Latitude and Longitude of point 1 (in decimal degrees)  :*/
/*::    lat2, lon2 = Latitude and Longitude of point 2 (in decimal degrees)  :*/
/*::    unit = the unit you desire for results                               :*/
/*::           where: 'M' is statute miles (default)                         :*/
/*::                  'K' is kilometers                                      :*/
/*::                  'N' is nautical miles                                  :*/
/*::  Worldwide cities and other features databases with latitude longitude  :*/
/*::  are available at https://www.geodatasource.com                         :*/
/*::                                                                         :*/
/*::  For enquiries, please contact sales@geodatasource.com                  :*/
/*::                                                                         :*/
/*::  Official Web site: https://www.geodatasource.com                       :*/
/*::                                                                         :*/
/*::           GeoDataSource.com (C) All Rights Reserved 2019                :*/
/*::                                                                         :*/
/*::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
