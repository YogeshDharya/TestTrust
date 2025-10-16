package com.example.geektrust.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.constant.MetroConstants;

public class AdultFareStrategyTest {
    @Test
    void testAdultFare(){
        AdultFareStrategy strategy = new AdultFareStrategy();
        int fare = strategy.calculateFare();
        assertEquals(MetroConstants.ADULT_FARE, fare);
    }    
}
