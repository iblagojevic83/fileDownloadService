package com.example.ifta.utils;

import com.example.ifta.models.enums.FileHeaderEnum;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileUtils {

    private static final String CSV = ".csv";
    private static final String TEXT = ".txt";

    public static CSVPrinter getCsvPrinter(File file) throws IOException {
        CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(file), CSVFormat.EXCEL);
        csvPrinter.printRecord(FileHeaderEnum.getHeadersList());
        csvPrinter.flush();
        return csvPrinter;
    }

    public static String getFileName(CSVFormat format) {
        String extension = CSVFormat.EXCEL.equals(format) ? CSV : TEXT;
        StringBuilder builder = new StringBuilder();
        builder.append("report").append(extension);
        return builder.toString();
    }
}
