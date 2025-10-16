package com.example.geektrust.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.constant.MetroConstants;

public class KidFareStrategyTest {
    @Test
    void testKidFare(){
        KidFareStrategy strategy = new KidFareStrategy();
        int fare = strategy.calculateFare();
        assertEquals(MetroConstants.KID_FARE, fare);
    }    

}
