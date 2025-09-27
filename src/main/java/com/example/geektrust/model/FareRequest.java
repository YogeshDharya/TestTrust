package com.example.geektrust.model;
import com.example.geektrust.constant.*;
public class FareRequest {
    private final int cardId;
    private final PassengerType passengerType;
    private final int stationId;
        public FareRequest(PassengerType passengerType,int cardId,int stationId ){
        this.cardId=cardId;
        this.stationId=stationId;
        this.passengerType=passengerType;
    }
    public int getCardId() {
        return cardId;
    }
    public PassengerType getPassengerType() {
        return passengerType;
    }
    public int getStationId() {
        return stationId;
    }

}
