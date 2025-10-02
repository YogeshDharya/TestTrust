package com.example.geektrust.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.geektrust.constant.PassengerType;

public class Station {
	private final String name;
	private int discount;
	private final Map<PassengerType,Integer> passengerCounts = new HashMap<>();
	private int revenue;
	public Station(String name) {
		this.name=name;
		for(PassengerType type: PassengerType.values()){
			this.passengerCounts.put(type,0);
		}
	}
	public void addRevenue(int amount) {
		this.revenue += amount;
	}
	public void addDiscount(int amount) {
		this.discount += amount;
	}
	public void addPassenger(PassengerType type, int count){
		this.passengerCounts.put(type, count);
	}
	public void addPassenger(PassengerType type){
		this.passengerCounts.put(type, 1);
	}
	public int getDiscount() {
		return this.discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getRevenue() {
		return this.revenue;
	}
	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}
	public String getName() {
		return this.name;
	}
	public SummaryDto getSummaryDTO(){
		List<SummaryDto.PassengerSummary> passengerSummaries = passengerCounts.entrySet()
		.stream()
		.filter(entry -> entry.getValue() > 0)  
		.map(entry -> new SummaryDto.PassengerSummary(entry.getKey(), entry.getValue()))
		.sorted(Comparator.comparing(ps -> ps.getType().name())) 
		.collect(Collectors.toList());
	
	return new SummaryDto(this.revenue, this.discount, passengerSummaries);	}
}