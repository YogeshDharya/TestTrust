package com.example.geektrust.repository.impl;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.model.Station;

public class StationRepositoryImpl {
	private Map<Integer,Station> stations;
	public StationRepositoryImpl() {
		this.stations = new HashMap<>();
	}
	
	public void saveStation(Station station) {
		this.stations.put(station.getId(), station);
	}
	
	public Station getStation(int id) {
		return this.stations.get(id);
	}
	
	public Map<Integer,Station> getStations(){
		return this.getStations();
	}
}
