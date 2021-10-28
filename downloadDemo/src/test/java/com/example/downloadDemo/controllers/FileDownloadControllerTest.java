package com.example.downloadDemo.controllers;

import com.example.downloadDemo.models.FileDataDto;
import com.example.downloadDemo.models.VehicleData;
import com.example.downloadDemo.models.enums.FileTypeEnum;
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
        List<VehicleData> vehicleData = new ArrayList<>();
        VehicleData data = new VehicleData("UA-test", "vehicleID-test", "lastActiveGroup-test",
                50, 50, 50,
                50, "AL-test", "AR-test", "AZ-test");
        VehicleData data1 = new VehicleData("UA-test-1", "vehicleID-test-1", "lastActiveGroup-test-1",
                50, 50, 50,
                50, "AL-test-1", "AR-test-1", "AZ-test-1");
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
