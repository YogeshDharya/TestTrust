package com.example.geektrust.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.constant.MetroConstants;

public class SeniorFareStrategyTest {
    @Test
    void testSeniorFare(){
        SeniorFareStrategy strategy = new SeniorFareStrategy();
        int fare = strategy.calculateFare();
        assertEquals(MetroConstants.SENIOR_FARE, fare);
    }    
}
