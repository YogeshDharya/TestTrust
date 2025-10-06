package com.example.geektrust.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.constant.MetroConstants;

public class KidFareStrategyTest {
    @Test
    void testKidFareWithoutReturnJourney(){
        KidFareStrategy strategy = new KidFareStrategy();
        int fare = strategy.calculateFare(false);
        assertEquals(MetroConstants.KID_FARE, fare);
    }    
    
    @Test 
    void testKidFareWithReturnJourney(){
        KidFareStrategy strategy = new KidFareStrategy();
        int fare = strategy.calculateFare(true);
        assertEquals(MetroConstants.KID_FARE/2, fare);
    }

}
