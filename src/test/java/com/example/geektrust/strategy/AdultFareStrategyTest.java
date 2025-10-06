package com.example.geektrust.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.constant.MetroConstants;

public class AdultFareStrategyTest {
    @Test
    void testAdultFareWithoutReturnJourney(){
        AdultFareStrategy strategy = new AdultFareStrategy();
        int fare = strategy.calculateFare(false);
        assertEquals(MetroConstants.ADULT_FARE, fare);
    }    
    
    @Test 
    void testAdultFareWithReturnJourney(){
        AdultFareStrategy strategy = new AdultFareStrategy();
        int fare = strategy.calculateFare(true);
        assertEquals(MetroConstants.ADULT_FARE/2, fare);
    }
}
