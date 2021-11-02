package com.example.ifta.services.impl;

import com.example.ifta.models.VehicleMileageReportItem;
import com.example.ifta.models.enums.RegisteredStateEnum;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.example.ifta.utils.FileUtils.*;

@Component
public class FileService {

    public File writeToFile(final VehicleMileageReportItem data) throws IOException {
        final CSVFormat format = CSVFormat.EXCEL;
        File file = new File(getFileName(format));
        CSVPrinter csvPrinter = getCsvPrinter(file);
        //TODO Instead 50 calculate total sum
        csvPrinter.printRecord(getFileRecord(data));
        csvPrinter.flush();
        csvPrinter.close();
        return file;
    }

    private Map<Integer, Integer> getStateHeaderIndex(Map<RegisteredStateEnum, Integer> states, List<String> headers) {
        Map<Integer, Integer> stateIndex = new HashMap<>();
        states.forEach((key, value) -> {
            Integer index = headers.indexOf(key.getCode());
            stateIndex.put(index, value);
        });

        return stateIndex;
    }

    private List<String> getBaseRecord(VehicleMileageReportItem data) {
        List<String> record = new ArrayList<>();
        record.add(data.getUA());
        record.add(data.getVehicleID());
        record.add(data.getLastActiveGroup());
        record.add(data.getBeginningOdometer().toString());
        record.add(data.getEndingOdometer().toString());
        //TODO add total odometer to DB
        record.add(data.getTotalVehicleMileage().toString());
        record.add(data.getTotalVehicleMileage().toString());
        return record;
    }

    private void addStateMileageData(List<String> baseRecord, Map<Integer, Integer> stateHeaderIndex, int headersSize) {
        for (int i = baseRecord.size(); i <= headersSize; i++) {
            Integer stateMileage = stateHeaderIndex.get(i);
            if (!Objects.isNull(stateMileage)) {
                baseRecord.add(Integer.toString(stateMileage));
            } else {
                baseRecord.add("");
            }
        }
    }

    private List<String> getFileRecord(final VehicleMileageReportItem data) {
        List<String> headers = getHeaders();
        List<String> baseRecord = getBaseRecord(data);
        addStateMileageData(baseRecord, getStateHeaderIndex(data.getStates(), headers), headers.size());
        return baseRecord;
    }


}
