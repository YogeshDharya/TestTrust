package com.example.geektrust.command;

import com.example.geektrust.service.MetroService;

public class PrintSummaryCommand implements Command{
	@Override
	public void execute(MetroService service,String[] args) {
		service.printSummary();
	}
}

