package com.example.geektrust.constant;

import com.example.geektrust.exception.InvalidPassengerException;

public enum PassengerType {
    ADULT("ADULT",MetroConstants.ADULT_FARE),
    SENIOR_CITIZEN("SENIOR_CITIZEN",MetroConstants.SENIOR_FARE),
    KID("KID",MetroConstants.KID_FARE);

    private final String typeName;
    private final int fare;
    PassengerType(String typeName,int fare){
        this.typeName=typeName;
        this.fare = fare;
    }

    public int getFare(){
        return this.fare;
    }

    public static PassengerType fromString(String type){
        for(PassengerType pt:values()){
            if(pt.typeName.equalsIgnoreCase(type)){
                return pt;
            }
        }
        throw new InvalidPassengerException("Invalid Passenger Type: "+type);
    }
}
