package com.example.geektrust.repository;

import java.util.List;


import com.example.geektrust.model.Station;

public interface StationRepository {
	public Station getStation(String name);
	public List<Station> getAllStations();
	public void saveStation(Station card);
}
