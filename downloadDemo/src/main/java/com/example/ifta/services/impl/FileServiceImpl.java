package com.example.ifta.services.impl;

import com.example.ifta.repository.IftaJurisdictionRepository;
import com.example.ifta.repository.RegisterStateRepository;
import com.example.ifta.repository.TruckMilesStateRepository;
import com.example.ifta.entities.IftaJurisdiction;
import com.example.ifta.entities.RegisterState;
import com.example.ifta.entities.TruckDrivenMilesState;
import com.example.ifta.models.VehicleData;
import com.example.ifta.models.enums.FileHeaderEnum;
import com.example.ifta.services.FileService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static com.example.ifta.utils.FileUtils.formatDateTime;

@Service
public class FileServiceImpl implements FileService {

    private final TruckMilesStateRepository truckMilesStateRepository;
    private final IftaJurisdictionRepository iftaJurisdictionRepository;
    private final RegisterStateRepository registerStateRepository;

    @Autowired
    public FileServiceImpl(TruckMilesStateRepository truckMilesStateDAO, IftaJurisdictionRepository iftaJurisdictionDAO, RegisterStateRepository registerStateDAO) {
        this.truckMilesStateRepository = truckMilesStateDAO;
        this.iftaJurisdictionRepository = iftaJurisdictionDAO;
        this.registerStateRepository = registerStateDAO;
    }

    @Override
    public File writeToFile(final String truckId) throws IOException {
        final VehicleData data = getVehicleData(truckId);
        final CSVFormat format = CSVFormat.EXCEL;
        File file = new File(getFileName(format));
        CSVPrinter csvPrinter = getCsvPrinter(file);
        //TODO Instead 50 calculate total sum
        csvPrinter.printRecord(Arrays.asList(data.getUA(), data.getVehicleID(), data.getLastActiveGroup(), data.getBeginningOdometer(),
                data.getEndingOdometer(), data.getTotalVehicleMileage(), data.getTotalVehicleMileage(), 50));
        csvPrinter.flush();
        csvPrinter.close();
        return file;
    }

    private CSVPrinter getCsvPrinter(File file) throws IOException {
        CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(file), CSVFormat.EXCEL);
        csvPrinter.printRecord(FileHeaderEnum.getHeadersList());
        csvPrinter.flush();
        return csvPrinter;
    }


    private VehicleData getVehicleData(String truckId) {
        TruckDrivenMilesState truckState = truckMilesStateRepository.findByTruckId(truckId);
        Optional<IftaJurisdiction> iftaJurisdiction = iftaJurisdictionRepository.findById(truckState.getStateJurisdiction());
        Optional<RegisterState> registerState = registerStateRepository.findByid(iftaJurisdiction.get().getRegisterStateId());
        final String state = registerState.get().getStateCode();
        return VehicleData.builder()
                .vehicleID(truckState.getTruckId())
                .endingOdometer(truckState.getEndOdometer())
                .states(new ArrayList(Arrays.asList(state)))
                .beginningOdometer(truckState.getStartOdometer())
                .totalVehicleMileage(truckState.getSumTotalMiles()).build();
    }

    private String getFileName(CSVFormat format) {
        String extension = CSVFormat.EXCEL.equals(format) ? ".csv" : ".txt";
        StringBuilder builder = new StringBuilder();
        builder.append("report").append("-").append(formatDateTime(new Date())).append(extension);
        return builder.toString();
    }

}
