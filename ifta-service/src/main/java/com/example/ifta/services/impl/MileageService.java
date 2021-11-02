package com.example.ifta.services.impl;

import com.example.ifta.entities.*;
import com.example.ifta.models.MileageSearchDto;
import com.example.ifta.models.VehicleMileageReportItem;
import com.example.ifta.models.enums.RegisteredStateEnum;
import com.example.ifta.models.search.TimeFilter;
import com.example.ifta.repository.IftaJurisdictionRepository;
import com.example.ifta.repository.RegisterStateRepository;
import com.example.ifta.repository.TruckMilesStateRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.*;

@Service
public class MileageService {

    private final TruckMilesStateRepository truckMilesStateRepository;
    private final IftaJurisdictionRepository iftaJurisdictionRepository;
    private final RegisterStateRepository registerStateRepository;
    private final FileService fileService;

    public MileageService(TruckMilesStateRepository truckMilesStateRepository, IftaJurisdictionRepository iftaJurisdictionRepository,
                          RegisterStateRepository registerStateRepository, FileService fileService) {
        this.truckMilesStateRepository = truckMilesStateRepository;
        this.iftaJurisdictionRepository = iftaJurisdictionRepository;
        this.registerStateRepository = registerStateRepository;
        this.fileService = fileService;
    }

    public File getTruckMileageReport(MileageSearchDto mileageSearchDto) throws IOException {
        final OffsetDateTime timeFrom = Optional.of(mileageSearchDto).map(MileageSearchDto::getStartTimeFilter).map(TimeFilter::getFrom).orElse(null);
        final OffsetDateTime timeTo = Optional.of(mileageSearchDto).map(MileageSearchDto::getEndTimeFilter).map(TimeFilter::getTo).orElse(null);
        List<VehicleMilesState> truckState = truckMilesStateRepository.findBySearchParams(timeFrom, timeTo);
        VehicleMileageReportItem vehicleData = prepareTruckData(truckState.get(0));
        return fileService.writeToFile(vehicleData);
    }

    private VehicleMileageReportItem prepareTruckData(VehicleMilesState truckState) {
        Map<RegisteredStateEnum, Integer> stateMileage = new HashMap<>();
        truckState.getTotalMileagesPerJurisdiction()
                .forEach(registerStateMileage -> stateMileage.put(registerStateMileage.getState(), registerStateMileage.getMileage()));
        return VehicleMileageReportItem.builder()
                .vehicleID(truckState.getTruckId())
                .endingOdometer(truckState.getEndOdometer())
                .beginningOdometer(truckState.getStartOdometer())
                .totalVehicleMileage(truckState.getSumTotalMiles()).states(stateMileage).build();
    }
}
