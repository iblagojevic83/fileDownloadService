package com.example.ifta.services.impl;

import com.example.ifta.entities.IftaJurisdiction;
import com.example.ifta.entities.RegisterState;
import com.example.ifta.entities.TruckDrivenMilesState;
import com.example.ifta.models.MileageSearchDto;
import com.example.ifta.models.VehicleMileageReportItem;
import com.example.ifta.models.search.TimeFilter;
import com.example.ifta.repository.IftaJurisdictionRepository;
import com.example.ifta.repository.RegisterStateRepository;
import com.example.ifta.repository.TruckMilesStateRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        List<TruckDrivenMilesState> truckState = truckMilesStateRepository.findBySearchParams(timeFrom, timeTo);
        Optional<IftaJurisdiction> iftaJurisdiction = iftaJurisdictionRepository.findById(truckState.get(0).getStateJurisdiction());
        Optional<RegisterState> registerState = registerStateRepository.findById(iftaJurisdiction.get().getRegisterStateId());
        VehicleMileageReportItem vehicleData = prepareTruckData(truckState.get(0), iftaJurisdiction, registerState);
        return fileService.writeToFile(vehicleData);
    }

    private VehicleMileageReportItem prepareTruckData(TruckDrivenMilesState truckState, Optional<IftaJurisdiction> iftaJurisdictio, Optional<RegisterState> registerState){
        final String state = registerState.get().getStateCode();
        return VehicleMileageReportItem.builder()
                .vehicleID(truckState.getTruckId())
                .endingOdometer(truckState.getEndOdometer())
                .states(new ArrayList(Arrays.asList(state)))
                .state(state)
                .beginningOdometer(truckState.getStartOdometer())
                .totalVehicleMileage(truckState.getSumTotalMiles()).build();
    }
}
