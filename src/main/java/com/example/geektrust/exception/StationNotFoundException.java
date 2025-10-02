package com.example.geektrust.exception;

public class StationNotFoundException extends RuntimeException{
    public StationNotFoundException(String msg){
        super(msg);
    }
}

