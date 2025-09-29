package com.example.geektrust.command;

import com.example.geektrust.service.MetroService;

public interface Command {
//TODO: Should be present in a separate package of interfaces since command classes are also expected to be in this very package ?
//TODO: MetroServiceI instead of the implementing class ?
 void execute(MetroService service, String[] args);
}
