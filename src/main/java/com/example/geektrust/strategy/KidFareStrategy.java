package com.example.geektrust.strategy;

import com.example.geektrust.constant.PassengerType;

public class KidFareStrategy implements FareStrategy{
    @Override
    public int calculateFare() {
    	return PassengerType.KID.getFare();
    }
}

