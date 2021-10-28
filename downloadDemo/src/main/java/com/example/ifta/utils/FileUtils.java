package com.example.ifta.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileUtils {

    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy.MM.dd.HH.mm.ss";

    public static String formatDateTime(Date date) {
        return formatDate(date, DATE_TIME_FORMAT_YYYY_MM_DD_HH_MM_SS);
    }

    public static String formatDate(Date date, String format) {
        DateFormat sdf = new SimpleDateFormat(format, Locale.US);
        return sdf.format(date);
    }
}
