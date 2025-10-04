package com.example.geektrust;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.example.geektrust.command.Command;
import com.example.geektrust.exception.MetroException;
import com.example.geektrust.factory.CommandFactory;
import com.example.geektrust.model.Card;
import com.example.geektrust.model.Station;
import com.example.geektrust.repository.CardRepository;
import com.example.geektrust.repository.StationRepository;
import com.example.geektrust.repository.impl.CardRepositoryImpl;
import com.example.geektrust.repository.impl.StationRepositoryImpl;
import com.example.geektrust.service.impl.MetroServiceImpl;


public class Main {
    public static void main(String[] args) {

        CardRepository cardRepository = CardRepositoryImpl.getInstance();
        StationRepository stationRepository = StationRepositoryImpl.getInstance();
        Map<String,Card> cardMap = cardRepository.getCards();
        cardMap.clear();
        System.out.println("Cleared repositories: " + cardMap.size() + " cards ");
        if (args.length < 1) {
            System.out.println("Input file required");
            return;
        }
        MetroServiceImpl service = MetroServiceImpl.getInstance(cardRepository,stationRepository);
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.trim().split("\\s+");
                    Command command = CommandFactory.createCommand(parts[0]);
                    command.execute(service, parts);
                    System.out.println("Continuing to the next command: " + String.join(" ", parts));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.err.println("Invalid command format " + e.getMessage() + " for line: " + line);
                } catch (MetroException e) {
                    System.err.println("Error processing command: " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Error reading file: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            System.out.println("✅ Finished reading all commands from file.");
        } catch (IOException e) {
            System.err.println("❌ Error reading file: " + e.getMessage());
        }
    }
}
