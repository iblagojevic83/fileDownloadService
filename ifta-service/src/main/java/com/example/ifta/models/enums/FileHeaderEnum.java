package com.example.ifta.models.enums;

import java.util.ArrayList;
import java.util.List;

public enum FileHeaderEnum {

    UA("UA"),
    VEHICLE_ID("Vehicle ID"),
    LAST_ACTIVE_GROUP("Last Active Group"),
    BEGINNING_ODOMETER("Beginning Odometer"),
    ENDING_ODOMETER("Ending Odometer"),
    TOTAL_ODOMETER("Total Odometer"),
    TOTAL_VEHICLE_MILEAGE("Total Vehicle Mileage"),
    CA("CA"),
    AL("AL"),
    AR("AR"),
    AZ("AZ");

    private String header;
    private static List<String> headersList = new ArrayList<>();

    FileHeaderEnum(String header) {
        this.header = header;
    }

    static {
        headersList.add(UA.getHeader());
        headersList.add(VEHICLE_ID.getHeader());
        headersList.add(LAST_ACTIVE_GROUP.getHeader());
        headersList.add(BEGINNING_ODOMETER.getHeader());
        headersList.add(ENDING_ODOMETER.getHeader());
        headersList.add(TOTAL_ODOMETER.getHeader());
        headersList.add(TOTAL_VEHICLE_MILEAGE.getHeader());
        headersList.add(AL.getHeader());
        headersList.add(AR.getHeader());
        headersList.add(AZ.getHeader());
        headersList.add(CA.getHeader());
    }

    public String getHeader() {
        return header;
    }


    public static List<String> getHeadersList() {
        return headersList;
    }
}
