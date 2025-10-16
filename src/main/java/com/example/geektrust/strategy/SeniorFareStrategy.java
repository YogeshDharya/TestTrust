package com.example.geektrust.strategy;

import com.example.geektrust.constant.PassengerType;

public class SeniorFareStrategy implements FareStrategy{
	@Override
	public int calculateFare() {
		return PassengerType.SENIOR_CITIZEN.getFare();
	}
}

