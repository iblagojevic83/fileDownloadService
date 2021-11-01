package com.example.ifta.models;

import com.example.ifta.entities.RegisterState;
import com.example.ifta.models.enums.RegisteredStateEnum;
import lombok.*;

import java.util.List;
import java.util.Map;

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
    private String state;

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
