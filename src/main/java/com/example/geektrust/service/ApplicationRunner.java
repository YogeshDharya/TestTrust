package com.example.geektrust.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.example.geektrust.command.Command;
import com.example.geektrust.exception.MetroException;
import com.example.geektrust.factory.CommandFactory;
import com.example.geektrust.repository.CardRepository;
import com.example.geektrust.repository.StationRepository;
import com.example.geektrust.repository.impl.CardRepositoryImpl;
import com.example.geektrust.repository.impl.StationRepositoryImpl;
import com.example.geektrust.service.impl.MetroServiceImpl;

public class ApplicationRunner {
        private final MetroServiceImpl metroService;
    private final CardRepository cardRepository;
    private final StationRepository stationRepository;

    public ApplicationRunner() {
        this.cardRepository = CardRepositoryImpl.getInstance();
        this.stationRepository = StationRepositoryImpl.getInstance();
        this.metroService = MetroServiceImpl.getInstance(cardRepository, stationRepository);
    }

    public void run(String inputFile) {
        CardRepositoryImpl.getInstance().clearExistingCards();
        processInputFile(inputFile);
    }

    private void processInputFile(String inputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                executeCommand(line);
            }
        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
        }
    }

    private void executeCommand(String line) {
        try {
            String[] parts = line.trim().split("\\s+");
            Command command = CommandFactory.createCommand(parts[0]);
            command.execute(metroService, parts);
        } catch (MetroException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Error processing command " + line + " .Error :" + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
