package com.example.geektrust.strategy;

import com.example.geektrust.constant.MetroConstants;

public class AdultFareStrategy implements FareStrategy{
	@Override
	public int calculateFare(boolean isReturn) {
		return isReturn ? MetroConstants.ADULT_FARE /2  : MetroConstants.ADULT_FARE;
	}
}
