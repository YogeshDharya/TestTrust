package com.example.geektrust.repository;

import java.util.Map;

import com.example.geektrust.model.Station;

public interface StationRepository {
	public Station getStation(String name);
	public Map<String,Station> getAllStations();
	// public List<Station> getAllStations();
	public void saveStation(Station card);
}
