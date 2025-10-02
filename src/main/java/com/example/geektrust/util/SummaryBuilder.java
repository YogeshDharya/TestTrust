package com.example.geektrust.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.geektrust.constant.PassengerType;
import com.example.geektrust.model.SummaryDto.PassengerSummary;

public class SummaryBuilder {
    private int totalCollection;
    private int totalDiscount;
    private List<PassengerSummary> passengerSummary = new ArrayList<>();

    public SummaryBuilder withTotalCollection(int totalCollection) {
        this.totalCollection = totalCollection;
        return this;
    }

    public SummaryBuilder withTotalDiscount(int totalDiscount) {
        this.totalDiscount = totalDiscount;
        return this;
    }

    // public SummaryBuilder withPassengerSummary(Map<PassengerType, Integer> passengerCounts) {
    //     passengerCounts.entrySet().stream()
    //         .filter(e -> e.getValue() > 0)
    //         .sorted((e1, e2) -> {
    //             int countCompare = e2.getValue().compareTo(e1.getValue());
    //             return countCompare != 0 ? countCompare : e1.getKey().getTypeName().compareTo(e2.getKey().getTypeName());
    //         })
    //         .forEach(e -> passengerSummary.add(new PassengerSummary(e.getKey(), e.getValue())));
    //     return this;
    // }

    // public SummaryDTO build() {
    //     return new SummaryDTO(totalCollection, totalDiscount, passengerSummary);
    // }
}
