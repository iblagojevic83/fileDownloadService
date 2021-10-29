package com.example.ifta.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleMileageReportItem {

    private String UA;
    private String vehicleID;
    private String lastActiveGroup;
    private Integer beginningOdometer;
    private Integer endingOdometer;
    private Integer totalOdometer;
    private Integer totalVehicleMileage;
    private List<String> states;

    @Override
    public String toString() {
        final String comma = ",";
        StringBuilder builder = new StringBuilder();
        builder
                .append(UA).append(comma)
                .append(vehicleID).append(comma)
                .append(lastActiveGroup).append(comma)
                .append(beginningOdometer).append(comma)
                .append(endingOdometer).append(comma)
                .append(totalOdometer).append(comma)
                .append(totalVehicleMileage);
        states.stream().forEach(state -> builder.append(state).append(comma));
        return builder.toString();
    }
}
