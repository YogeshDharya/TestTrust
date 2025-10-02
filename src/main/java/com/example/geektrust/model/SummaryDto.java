package com.example.geektrust.model;

import java.util.List;

import com.example.geektrust.constant.PassengerType;

public class SummaryDto {
	private final int totalCollection;
	private final int totalDiscount;
	private final List<PassengerSummary> passengerSummary;

	public SummaryDto(int totalCollection, int totalDiscount, List<PassengerSummary> passengerSummary) {
		this.passengerSummary = passengerSummary;
		this.totalCollection = totalCollection;
		this.totalDiscount = totalDiscount;
	}

	// public String formatSummary(String stationName) {
	// 	StringBuilder sb = new StringBuilder();
	// 	sb.append("TOTAL_COLLECTION ").append(stationName).append(" ").append(this.totalCollection).append(" ")
	// 			.append(this.totalDiscount).append("\n").append("PASSENGER_TYPE_SUMMARY\n");
	// 	passengerSummary
	// 			.forEach(ps -> sb.append(ps.getType()).append(" ").append(ps.getCount()).append("\n"));
	// 	return sb.toString();
	// }

	public String formatSummary(String stationName) {
        StringBuilder sb = new StringBuilder();
        sb.append("TOTAL_COLLECTION ").append(stationName).append(" ")
          .append(totalCollection).append(" ").append(totalDiscount).append("\n")
          .append("PASSENGER_TYPE_SUMMARY\n");
        // Sort by count descending, then type name alphabetically
        passengerSummary.stream()
            .sorted((ps1, ps2) -> {
                int countCompare = Integer.compare(ps2.getCount(), ps1.getCount());
                return countCompare != 0 ? countCompare : ps1.getType().getTypeName().compareTo(ps2.getType().getTypeName());
            })
            .forEach(ps -> sb.append(ps.getType().getTypeName()).append(" ").append(ps.getCount()).append("\n"));
        return sb.toString();
    }

	public static class PassengerSummary {
		private final PassengerType type;
		private final int count;

		public PassengerSummary(PassengerType type, int count) {
			this.type = type;
			this.count = count;
		}

		public PassengerType getType() {
			return type;
		}

		public int getCount() {
			return count;
		}
	}
}
