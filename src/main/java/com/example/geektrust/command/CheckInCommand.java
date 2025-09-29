package com.example.geektrust.command;

import com.example.geektrust.service.MetroService;

public class CheckInCommand implements Command{
	@Override
	public void execute(MetroService service,String[] args) {
		int cardId = Integer.parseInt(args[1]);
		String station = args[3];
		service.checkIn(station);
	}
}
