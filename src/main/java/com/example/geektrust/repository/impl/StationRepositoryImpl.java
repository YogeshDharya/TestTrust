package com.example.geektrust.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.geektrust.constant.MetroConstants;
import com.example.geektrust.model.Station;
import com.example.geektrust.repository.StationRepository;

public class StationRepositoryImpl implements StationRepository{
	private Map<String,Station> stations;
	private static StationRepositoryImpl instance;
	private StationRepositoryImpl() {
		this.stations = new HashMap<>();
		Station central = new Station(MetroConstants.CENTRAL);
		Station airport = new Station(MetroConstants.AIRPORT);
		this.stations.put(MetroConstants.CENTRAL,central);
		this.stations.put(MetroConstants.AIRPORT,airport);
	}
	public static StationRepositoryImpl getInstance(){
		if(instance == null){
			instance= new StationRepositoryImpl();
		}
		return instance; 
	}
	@Override
	public Station getStation(String stationName){
          return this.stations.get(stationName);
	}
	@Override
	public void saveStation(Station station) {
		this.stations.put(station.getName(), station);
	}
	@Override
	public List<Station> getAllStations() {
		return new ArrayList<>(this.stations.values());
	}
}
