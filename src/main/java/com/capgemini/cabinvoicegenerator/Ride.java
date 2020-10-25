package com.capgemini.cabinvoicegenerator;

public class Ride {
	public enum RideType {
		NORMAL, PREMIUM
	}

	public double distnce;
	public int time;
	public RideType rideType;

	public Ride(double distance, int time, RideType rideType) {
		this.distnce = distance;
		this.time = time;
		this.rideType = rideType;
	}
}
