package com.example.geektrust.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.constant.MetroConstants;

public class SeniorFareStrategyTest {
    @Test
    void testSeniorFareWithoutReturnJourney(){
        SeniorFareStrategy strategy = new SeniorFareStrategy();
        int fare = strategy.calculateFare(false);
        assertEquals(MetroConstants.SENIOR_FARE, fare);
    }    
    
    @Test 
    void testSeniorFareWithReturnJourney(){
        SeniorFareStrategy strategy = new SeniorFareStrategy();
        int fare = strategy.calculateFare(true);
        assertEquals(MetroConstants.SENIOR_FARE/2, fare);
    }
    
}
