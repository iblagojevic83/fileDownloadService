package com.example.ifta.services;

import java.io.File;
import java.io.IOException;


public interface FileService {

    File writeToFile(String truckId) throws IOException;


}
