package com.example.geektrust.strategy;

import com.example.geektrust.constant.PassengerType;

public class AdultFareStrategy implements FareStrategy{
	@Override
	public int calculateFare() {
		return PassengerType.ADULT.getFare();
	}
}