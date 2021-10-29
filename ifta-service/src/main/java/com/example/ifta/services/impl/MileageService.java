package com.example.ifta.services.impl;

import com.example.ifta.entities.IftaJurisdiction;
import com.example.ifta.entities.RegisterState;
import com.example.ifta.entities.TruckDrivenMilesState;
import com.example.ifta.models.VehicleMileageReportItem;
import com.example.ifta.repository.IftaJurisdictionRepository;
import com.example.ifta.repository.RegisterStateRepository;
import com.example.ifta.repository.TruckMilesStateRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
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

    public File getTruckMileageReport(String truckId) throws IOException {
        List<TruckDrivenMilesState> truckState = truckMilesStateRepository.findByTruckId(truckId);
        Optional<IftaJurisdiction> iftaJurisdiction = iftaJurisdictionRepository.findById(truckState.get(0).getStateJurisdiction());
        Optional<RegisterState> registerState = registerStateRepository.findByid(iftaJurisdiction.get().getRegisterStateId());
        VehicleMileageReportItem vehicleData = prepareTruckData(truckState.get(0), iftaJurisdiction, registerState);
        return fileService.writeToFile(vehicleData);
    }

    private VehicleMileageReportItem prepareTruckData(TruckDrivenMilesState truckState, Optional<IftaJurisdiction> iftaJurisdictio, Optional<RegisterState> registerState){
        final String state = registerState.get().getStateCode();
        return VehicleMileageReportItem.builder()
                .vehicleID(truckState.getTruckId())
                .endingOdometer(truckState.getEndOdometer())
                .states(new ArrayList(Arrays.asList(state)))
                .beginningOdometer(truckState.getStartOdometer())
                .totalVehicleMileage(truckState.getSumTotalMiles()).build();
    }
}
