package com.capgemini.cabinvoicetest;

import org.junit.Test;

import com.capgemini.cabinvoicegenerator.Invoice;
import com.capgemini.cabinvoicegenerator.InvoiceGenerator;
import com.capgemini.cabinvoicegenerator.InvoiceSummary;
import com.capgemini.cabinvoicegenerator.Ride;
import com.capgemini.cabinvoicegenerator.RideRepository;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;

public class TestClass {
	InvoiceGenerator invoiceGenerator;

	@Before
	public void setUp() {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceTimeReturnFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceTimeReturnMinFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRideReturnInvoiceSummary() {
		Invoice invoice = new Invoice();
		Ride[] rides = { new Ride(2.0, 5, Ride.RideType.NORMAL), new Ride(0.1, 1, Ride.RideType.NORMAL) };
		InvoiceSummary summary = invoice.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30.0);
		Assert.assertEquals(expectedSummary, summary);
	}

	@Test
	public void givenUserIdReturnInvoiceSummary() {
		String userId = "samiul";
		RideRepository rideRepository = new RideRepository();
		Ride[] rides = { new Ride(2.0, 5, Ride.RideType.NORMAL), new Ride(0.1, 1, Ride.RideType.PREMIUM) };
		rideRepository.addUserRide(userId, rides);
		Ride[] userRides = rideRepository.getUserRides(userId);
		Assert.assertEquals(rides[1], userRides[1]);
	}

	@Test
	public void givenMultipleTypeRideReturnInvoiceSummary() {
		Invoice invoice = new Invoice();
		Ride[] rides = { new Ride(2.0, 5, Ride.RideType.PREMIUM), new Ride(0.1, 1, Ride.RideType.NORMAL) };
		InvoiceSummary summary = invoice.calculateFare(rides);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 45.0);
		Assert.assertEquals(expectedSummary, summary);
	}
}
