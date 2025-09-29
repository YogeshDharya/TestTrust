package com.example.geektrust.strategy;

import com.example.geektrust.constant.MetroConstants;

public class SeniorFareStrategy implements FareStrategy{
	@Override
	public int calculateFare(boolean isReturn) {
		return isReturn ? MetroConstants.SENIOR_FARE/2 : MetroConstants.SENIOR_FARE;
	}
}
