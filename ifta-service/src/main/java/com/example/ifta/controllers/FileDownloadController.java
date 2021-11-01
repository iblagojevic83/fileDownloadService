package com.example.ifta.controllers;

import com.example.ifta.models.MileageSearchDto;
import com.example.ifta.services.impl.MileageService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class FileDownloadController {

    private final MileageService mileageService;

    @Autowired
    public FileDownloadController(MileageService mileageService) {
        this.mileageService = mileageService;
    }

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void downloadMileageReport(final MileageSearchDto searchDto, HttpServletResponse response) throws IOException {
        final File file = mileageService.getTruckMileageReport(searchDto);
        streamFile(file, response);
    }

    private void streamFile(final File file, HttpServletResponse response) throws IOException{
        IOUtils.copy(new FileInputStream(file), response.getOutputStream());
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName());
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.flushBuffer();
    }
}
