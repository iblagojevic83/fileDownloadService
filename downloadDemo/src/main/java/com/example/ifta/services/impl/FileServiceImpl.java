package com.example.ifta.services.impl;

import com.example.ifta.repository.IftaJurisdictionRepository;
import com.example.ifta.repository.RegisterStateRepository;
import com.example.ifta.repository.TruckMilesStateRepository;
import com.example.ifta.entities.IftaJurisdiction;
import com.example.ifta.entities.RegisterState;
import com.example.ifta.entities.TruckDrivenMilesState;
import com.example.ifta.models.VehicleData;
import com.example.ifta.models.enums.FileHeaderEnum;
import com.example.ifta.models.enums.FileTypeEnum;
import com.example.ifta.services.FileService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import static com.example.ifta.utils.FileUtils.formatDateTime;

@Service
public class FileServiceImpl implements FileService {

    private final TruckMilesStateRepository truckMilesStateDAO;
    private final IftaJurisdictionRepository iftaJurisdictionDAO;
    private final RegisterStateRepository registerStateDAO;

    @Autowired
    public FileServiceImpl(TruckMilesStateRepository truckMilesStateDAO, IftaJurisdictionRepository iftaJurisdictionDAO, RegisterStateRepository registerStateDAO) {
        this.truckMilesStateDAO = truckMilesStateDAO;
        this.iftaJurisdictionDAO = iftaJurisdictionDAO;
        this.registerStateDAO = registerStateDAO;
    }

    @Override
    public File writeToFile(String truckId) throws IOException {
        VehicleData data = getVehicleData(truckId);
        CSVFormat format = getFormat();
        File file = new File(getFileName(format));
        CSVPrinter csvPrinter = getCsvPrinter(file);
        csvPrinter.printRecord(Arrays.asList(data.getUA(), data.getVehicleID(), data.getLastActiveGroup(), data.getBeginningOdometer(),
                data.getEndingOdometer(), data.getTotalVehicleMileage(), data.getTotalVehicleMileage(), data.getAL(), data.getAR(), data.getAZ()));
        csvPrinter.flush();
        csvPrinter.close();
        return file;
    }

    private CSVPrinter getCsvPrinter(File file) throws IOException {
        CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(file), getFormat());
        csvPrinter.printRecord(FileHeaderEnum.getHeadersList());
        csvPrinter.flush();
        return csvPrinter;
    }


    private VehicleData getVehicleData(String truckId) {
        TruckDrivenMilesState truckState = truckMilesStateDAO.findByTruckId(truckId);
        IftaJurisdiction iftaJurisdiction = iftaJurisdictionDAO.getById(truckState.getStateJurisdiction());
        RegisterState registerState = registerStateDAO.getById(iftaJurisdiction.getRegisterStateId());
        return VehicleData.builder().vehicleID(truckState.getTruckId()).endingOdometer(truckState.getEndOdometer())
                .beginningOdometer(truckState.getStartOdometer()).totalVehicleMileage(truckState.getSumTotalMiles()).build();
    }

    private String getFileName(CSVFormat format) {
        String extension = CSVFormat.EXCEL.equals(format) ? ".csv" : ".txt";
        StringBuilder builder = new StringBuilder();
        builder.append("report").append("-").append(formatDateTime(new Date())).append(extension);
        return builder.toString();
    }

    private CSVFormat getFormat() {
        return CSVFormat.EXCEL;
    }

}
