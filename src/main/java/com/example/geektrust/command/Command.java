package com.example.geektrust.command;

import com.example.geektrust.service.MetroService;

public interface Command {
 void execute(MetroService service, String[] args);
}
