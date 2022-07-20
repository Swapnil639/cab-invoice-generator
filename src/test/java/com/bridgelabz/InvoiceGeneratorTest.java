package com.bridgelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {
    InvoiceGenerator generator = new InvoiceGenerator();
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = generator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = generator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);

    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(10.0, 15),
                new Ride(0.1, 1)
        };
        InvoiceSummary invoiceSummary = generator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 120);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenTwoDifferentRidesPremiumAndNormalRide_FindTotalFareSummary() {
        double distance = 10;
        int time = 15;
        Assert.assertEquals(115, generator.calculateFare(distance, time), 0.0);
        Assert.assertEquals(230, generator.calculatePremiumFare(distance, time), 0.0);
    }

    @Test
    public void premiumMinimumFare() {
        double distance = 0.1;
        int time = 1;
        Assert.assertEquals(20, generator.calculatePremiumFare(distance, time), 0.0);

    }
}