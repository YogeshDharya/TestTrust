package com.example.geektrust.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.model.Station;

public class StationRepository {
	private Map<Integer,Station> stations;
	public StationRepository() {
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
