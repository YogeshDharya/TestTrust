package com.example.geektrust.factory;

import com.example.geektrust.constant.PassengerType;
import com.example.geektrust.exception.InvalidFareStrategyException;
import com.example.geektrust.strategy.AdultFareStrategy;
import com.example.geektrust.strategy.FareStrategy;
import com.example.geektrust.strategy.KidFareStrategy;
import com.example.geektrust.strategy.SeniorFareStrategy;

public class FareStrategyFactory {
 public static FareStrategy getStrategy(PassengerType type) {
	 switch(type) {
	 case ADULT: return new AdultFareStrategy();
	 case SENIOR_CITIZEN: return new SeniorFareStrategy();
	 case KID: return new KidFareStrategy();
	 default: throw new InvalidFareStrategyException("No Fare Strategy exists for the passenger type " + type);
	 }
 }
}

