package com.example.geektrust.command;

import com.example.geektrust.constant.PassengerType;
import com.example.geektrust.service.MetroService;

public class CheckInCommand implements Command{
	
	@Override
	public void execute(MetroService service,String[] args) {
		String cardId = args[1];
		PassengerType passengerType = PassengerType.fromString(args[2]);
		String station = args[3];
		service.checkIn(cardId,passengerType,station);
	}
}
