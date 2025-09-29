package com.example.geektrust.strategy;

public interface FareStrategy {
	int calculateFare(boolean isReturn);
//TODO: isReturn below ? and fare/2 should be round off ?
//	default int getDiscount(int fare) {
//		return isReturn ? fare/2 : 0;
//	}
}
