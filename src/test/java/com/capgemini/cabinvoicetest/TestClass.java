package com.capgemini.cabinvoicetest;

import org.junit.Test;

import com.capgemini.cabinvoicegenerator.InvoiceGenerator;

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
}
