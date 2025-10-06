package com.example.geektrust.command;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.repository.impl.CardRepositoryImpl;
import com.example.geektrust.repository.impl.StationRepositoryImpl;
import com.example.geektrust.service.MetroService;
import com.example.geektrust.service.impl.MetroServiceImpl;

public class PrintSummaryCommandTest {
    private MetroService metroService;
    private PrintSummaryCommand printSummaryCommand;

    @BeforeEach
    public void setUp() {
        metroService = MetroServiceImpl.getInstance(
                CardRepositoryImpl.getInstance(),
                StationRepositoryImpl.getInstance());
        printSummaryCommand = new PrintSummaryCommand();
    }

    @Test
    public void testExecute_ShouldPrintSummaryWithoutError() {
        assertDoesNotThrow(() -> printSummaryCommand.execute(metroService, new String[] { "PRINT_SUMMARY" }));
    }
}
