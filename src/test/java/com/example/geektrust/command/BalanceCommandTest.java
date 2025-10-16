package com.example.geektrust.command;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.repository.impl.CardRepositoryImpl;
import com.example.geektrust.repository.impl.StationRepositoryImpl;
import com.example.geektrust.service.MetroService;
import com.example.geektrust.service.impl.MetroServiceImpl;

public class BalanceCommandTest {
 private MetroService metroService;
    private BalanceCommand balanceCommand;

    @BeforeEach
    public void setUp() {
        metroService = MetroServiceImpl.getInstance(
                CardRepositoryImpl.getInstance(),
                StationRepositoryImpl.getInstance());
        balanceCommand = new BalanceCommand();
    }

    @Test
    public void testExecute_ShouldAddBalanceToCard() {
        String[] parts = {"BALANCE", "MC1", "500"};

        balanceCommand.execute(metroService, parts);
        assertTrue(metroService.getCardRepository()
                .getCard("MC1") != null,
                "Card should be added after balance command");
    }

    @Test
    public void testExecute_ShouldHandleInvalidFormat() {
        String[] parts = {"BALANCE", "MC1"};

        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> balanceCommand.execute(metroService, parts));
    }
}
