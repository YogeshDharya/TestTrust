package com.example.geektrust;

import com.example.geektrust.service.ApplicationRunner;

public class Main {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("An input file is required");
            return;
        }
        new ApplicationRunner().run(args[0]);
    }
}
