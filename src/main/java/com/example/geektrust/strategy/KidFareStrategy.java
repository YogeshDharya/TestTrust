package com.example.geektrust.strategy;

import com.example.geektrust.constant.MetroConstants;

public class KidFareStrategy implements FareStrategy{
    @Override
    public int calculateFare(boolean isReturn) {
    	return isReturn ? MetroConstants.KID_FARE /2 : MetroConstants.KID_FARE;
    }
}

