package com.example.downloadDemo.services.impl;

import com.example.downloadDemo.dao.IftaJurisdictionDAO;
import com.example.downloadDemo.dao.RegisterStateDAO;
import com.example.downloadDemo.dao.TruckMilesStateDAO;
import com.example.downloadDemo.entities.IftaJurisdiction;
import com.example.downloadDemo.entities.RegisterState;
import com.example.downloadDemo.entities.TruckDrivenMilesState;
import com.example.downloadDemo.models.VehicleData;
import com.example.downloadDemo.models.enums.FileHeaderEnum;
import com.example.downloadDemo.models.enums.FileTypeEnum;
import com.example.downloadDemo.services.FileService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import static com.example.downloadDemo.utils.FileUtils.formatDateTime;

@Service
public class FileServiceImpl implements FileService {

    private final TruckMilesStateDAO truckMilesStateDAO;
    private final IftaJurisdictionDAO iftaJurisdictionDAO;
    private final RegisterStateDAO registerStateDAO;

    @Autowired
    public FileServiceImpl(TruckMilesStateDAO truckMilesStateDAO, IftaJurisdictionDAO iftaJurisdictionDAO, RegisterStateDAO registerStateDAO) {
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
        //return isExel(fileType) ? CSVFormat.EXCEL : CSVFormat.DEFAULT;
    }

    private boolean isExel(String fileType) {
        return FileTypeEnum.EXEL.name().equals(fileType.toUpperCase());
    }


}
