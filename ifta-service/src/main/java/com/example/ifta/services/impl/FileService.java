package com.example.ifta.services.impl;

import com.example.ifta.models.VehicleMileageReportItem;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.ifta.utils.FileUtils.*;

@Component
public class FileService {

    public File writeToFile(final VehicleMileageReportItem data) throws IOException {
        final CSVFormat format = CSVFormat.EXCEL;
        File file = new File(getFileName(format));
        CSVPrinter csvPrinter = getCsvPrinter(file);
        //TODO Instead 50 calculate total sum
        csvPrinter.printRecord(getRecord(data));
        csvPrinter.flush();
        csvPrinter.close();
        return file;
    }

    private List<String> getRecord(final VehicleMileageReportItem data) {
        List<String> headers = getHeaders();
        int stateIndex = getHeaders().indexOf(data.getState());
        List<String> record = new ArrayList<>();
        record.add(data.getUA());
        record.add(data.getVehicleID());
        record.add(data.getLastActiveGroup());
        record.add(data.getBeginningOdometer().toString());
        record.add(data.getEndingOdometer().toString());
        //TODO add total odometer to DB
        record.add(data.getTotalVehicleMileage().toString());
        record.add(data.getTotalVehicleMileage().toString());
        for (int i = record.size(); i <= stateIndex; i++) {
            if (i == stateIndex) {
                record.add(data.getTotalVehicleMileage().toString());
            } else {
                record.add("");
            }
        }
        return record;
    }

}
