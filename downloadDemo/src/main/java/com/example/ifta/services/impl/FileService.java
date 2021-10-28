package com.example.ifta.services.impl;

import com.example.ifta.models.VehicleData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static com.example.ifta.utils.FileUtils.getCsvPrinter;
import static com.example.ifta.utils.FileUtils.getFileName;

@Component
public class FileService {

    public File writeToFile(final VehicleData data) throws IOException {
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

}
