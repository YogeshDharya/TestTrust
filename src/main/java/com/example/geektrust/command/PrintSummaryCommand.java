package com.example.geektrust.command;

import com.example.geektrust.service.MetroService;

public class PrintSummaryCommand implements Command{
	@Override
	public void execute(MetroService service,String[] args) {
		System.out.println("About to print summary command ");
		service.printSummary();
	}
}

