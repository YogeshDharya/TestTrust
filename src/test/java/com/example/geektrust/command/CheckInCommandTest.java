package com.example.geektrust.command;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.repository.impl.CardRepositoryImpl;
import com.example.geektrust.repository.impl.StationRepositoryImpl;
import com.example.geektrust.service.MetroService;
import com.example.geektrust.service.impl.MetroServiceImpl;

public class CheckInCommandTest {
    private MetroService metroService;
    private CheckInCommand checkInCommand;

    @BeforeEach
    public void setUp() {
        metroService = MetroServiceImpl.getInstance(
                CardRepositoryImpl.getInstance(),
                StationRepositoryImpl.getInstance());
        checkInCommand = new CheckInCommand();
    }

    @Test
    public void testExecute_ShouldCheckInPassenger() {
        new BalanceCommand().execute(metroService, new String[] { "BALANCE", "MC1", "200" });

        String[] parts = { "CHECK_IN", "MC1", "ADULT", "CENTRAL" };

        assertDoesNotThrow(() -> checkInCommand.execute(metroService, parts));
    }

    @Test
    public void testExecute_ShouldThrowExceptionForInvalidPassengerType() {
        new BalanceCommand().execute(metroService, new String[] { "BALANCE", "MC1", "200" });

        String[] parts = { "CHECK_IN", "MC1", "INVALID", "CENTRAL" };

        assertThrows(RuntimeException.class,
                () -> checkInCommand.execute(metroService, parts));
    }
}
