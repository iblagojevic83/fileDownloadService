package com.example.ifta.controllers;

import com.example.ifta.models.FileDataDto;
import com.example.ifta.models.VehicleMileageReportItem;
import com.example.ifta.models.enums.FileTypeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FileDownloadControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void fileDownloadControllerReturnsStatusOkAnd() {
        //TODO change
        FileDataDto fileData = getFileData();
        HttpEntity<FileDataDto> entity = new HttpEntity<>(fileData, new HttpHeaders());
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/download"), HttpMethod.POST, entity, String.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
        List<String> vehicleDataFromBody = getVehicleDataFromBody(response.getBody());
        System.out.println(response.getBody());
        for (int i = 0; i >= vehicleDataFromBody.size(); i++) {
            Assert.assertEquals(vehicleDataFromBody.get(i), fileData.getVehicleData().get(i).toString());
        }
    }

    private List<String> getVehicleDataFromBody(String body) {
        List<String> allData = Arrays.asList(body.split("\n"));
        return allData.subList(1, allData.size());
    }

    private FileDataDto getFileData() {
        FileDataDto fileDataDto = new FileDataDto();
        List<VehicleMileageReportItem> vehicleData = new ArrayList<>();
        VehicleMileageReportItem data = new VehicleMileageReportItem("UA-test", "vehicleID-test", "lastActiveGroup-test",
                50, 50, 50,
                50, new HashMap<>());
        VehicleMileageReportItem data1 = new VehicleMileageReportItem("UA-test-1", "vehicleID-test-1", "lastActiveGroup-test-1",
                50, 50, 50,
                50, new HashMap<>());
        vehicleData.add(data);
        vehicleData.add(data1);
        fileDataDto.setFileType(FileTypeEnum.CSV.name());
        fileDataDto.setVehicleData(vehicleData);
        return fileDataDto;
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
