package com.example.geektrust.constant;

public enum PassengerType {
    ADULT("ADULT"),
    SENIOR_CITIZEN("SENIOR_CITIZEN"),
    KID("KID");

    private final String typeName;
    PassengerType(String typeName){
        this.typeName=typeName;
    }
    private String getType(){
        return this.typeName;
    }
    public static PassengerType fromString(String type){
        for(PassengerType pt:values()){
            if(pt.typeName.equalsIgnoreCase(type)){
                return pt;
            }
        }
        throw new IllegalArgumentException("Invalid Passenger Type: "+type);
    }
}
