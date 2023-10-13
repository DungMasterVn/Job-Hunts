package com.example.demo.service;

import com.example.demo.exception.StorageException;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class StorageService {
    @Value("${upload.path}")
    private String path;
    private String getFileExtension(String fileName){
        int postOfDot = fileName.lastIndexOf(".");
        if(postOfDot >= 0){
            return fileName.substring(postOfDot + 1);
        } else {
            return null;
        }
    }
    public String saveFile(MultipartFile file, String id) throws IOException{
        if(file.isEmpty()){
            throw new StorageException("Fail to upload empty file!");
        }
        String extension = getFileExtension(file.getOriginalFilename());
        String fileName = path + id + "." + extension;

        try{
            var is = file.getInputStream();
            Files.copy(is, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
            return (id + "." + extension);
        } catch (IOException e) {
            var msg = String.format("Fail to store file %s",fileName);
            throw new StorageException(msg,e);
        }
    }
}
