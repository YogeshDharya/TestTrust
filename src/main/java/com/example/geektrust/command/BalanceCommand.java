package com.example.geektrust.command;

import com.example.geektrust.service.MetroService;

public class BalanceCommand implements Command{
	@Override
	public void execute(MetroService service, String[] args) {
		int cardId = Integer.parseInt(args[1]);
		int amount = Integer.parseInt(args[2]);
		service.balance(cardId, amount);
	}
}
