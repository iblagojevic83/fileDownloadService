package com.example.ifta.controllers;

import com.example.ifta.services.FileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
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

    private final FileService fileService;

    @Autowired
    public FileDownloadController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void downloadFile(@RequestParam("truckId") String truckId, HttpServletResponse response) throws IOException {
        File file = fileService.writeToFile(truckId);
        IOUtils.copy(new FileInputStream(file), response.getOutputStream());
        response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName());
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.flushBuffer();
    }
}
