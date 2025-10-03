package com.example.geektrust;

import java.io.BufferedReader;
import java.io.FileReader;

import com.example.geektrust.command.Command;
import com.example.geektrust.exception.MetroException;
import com.example.geektrust.factory.CommandFactory;
import com.example.geektrust.service.impl.MetroServiceImpl;


public class Main {
    public static void main(String[] args) {
        
        if (args.length < 1) {
            System.out.println("Input file required");
            return;
        }
        MetroServiceImpl service = MetroServiceImpl.getInstance();
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split(" ");
                    Command command = CommandFactory.createCommand(parts[0], parts);
                    command.execute(service, parts);
                } catch (MetroException e) {
                    System.err.println("Error processing command: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
