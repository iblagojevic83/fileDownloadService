package com.example.ifta.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleData {

    private String UA;
    private String vehicleID;
    private String lastActiveGroup;
    private Integer beginningOdometer;
    private Integer endingOdometer;
    private Integer totalOdometer;
    private Integer totalVehicleMileage;
    private String AL;
    private String AR;
    private String AZ;

    @Override
    public String toString() {
        String comma = ",";
        StringBuilder builder = new StringBuilder();
        builder.append(UA).append(comma).append(vehicleID).append(comma).append(lastActiveGroup).append(comma)
                .append(beginningOdometer).append(comma).append(endingOdometer).append(comma).append(totalOdometer).append(comma)
                .append(totalVehicleMileage).append(comma).append(AL).append(comma).append(AR).append(comma).append(AZ);
        return builder.toString();

    }
}
