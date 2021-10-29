package com.example.ifta.utils;

import com.example.ifta.models.enums.FileHeaderEnum;
import com.example.ifta.models.enums.RegisteredStateEnum;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    private static final String CSV = ".csv";
    private static final String TEXT = ".txt";

    public static CSVPrinter getCsvPrinter(File file) throws IOException {
        CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(file), CSVFormat.EXCEL);
        csvPrinter.printRecord(getHeaders());
        csvPrinter.flush();
        return csvPrinter;
    }

    public static List<String> getHeaders() {
        List<String> headers = new ArrayList<>();
        headers.addAll(FileHeaderEnum.getHeadersList());
        headers.addAll(RegisteredStateEnum.getCodeList());
        return headers;
    }

    public static String getFileName(CSVFormat format) {
        String extension = CSVFormat.EXCEL.equals(format) ? CSV : TEXT;
        StringBuilder builder = new StringBuilder();
        builder.append("report").append(extension);
        return builder.toString();
    }
}
