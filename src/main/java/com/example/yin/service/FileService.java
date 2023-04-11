package com.example.yin.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {
    public void writeToFile(String fileName, String content) throws IOException {
        File file = new File(fileName);
        if(!file.exists())
        {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileUtils.writeStringToFile(file, content, "UTF-8");
    }

    public String readFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        return FileUtils.readFileToString(file, "UTF-8");
    }

    public void writeToImage(String fileName, MultipartFile file) throws IOException {
        if (file.isEmpty()) return;
        File dest = new File(fileName);
        if(!dest.exists())
        {
            try {
                dest.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileUtils.writeByteArrayToFile(dest, file.getBytes());
    }
}
