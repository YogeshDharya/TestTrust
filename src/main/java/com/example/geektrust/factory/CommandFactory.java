package com.example.geektrust.factory;

import com.example.geektrust.command.BalanceCommand;
import com.example.geektrust.command.CheckInCommand;
import com.example.geektrust.command.Command;
import com.example.geektrust.command.PrintSummaryCommand;
import com.example.geektrust.exception.InvalidCommandException;

public class CommandFactory {
	public static Command createCommand(String command) {
	// public static Command createCommand(String command,String[]args) {
		switch(command.toUpperCase()) {
		case "BALANCE": return new BalanceCommand();
		case "CHECK_IN": return new CheckInCommand();
		case "PRINT_SUMMARY": return new PrintSummaryCommand();
		default: throw new InvalidCommandException("This Command " + command + " does not exist");
		}
	}
}
