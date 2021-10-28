package com.example.downloadDemo.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileDataDto {

    private String fileType;
    List<VehicleData> vehicleData;

}
