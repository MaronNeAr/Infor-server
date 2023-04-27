package com.example.yin.controller;

import com.example.yin.config.common.ErrorMessage;
import com.example.yin.config.common.SuccessMessage;
import com.example.yin.service.DocumentService;
import com.example.yin.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @Autowired
    private DocumentService documentService;

    @PostMapping("/file")
    public Object uploadDocument(@RequestParam("file") MultipartFile multipartFile, @RequestParam("type") String type, @RequestParam("id") String id) throws IOException {
        try {
            String fileName = "document/" + type + "/" + id + "." + type;
            fileService.writeToFile(fileName, multipartFile);
            return new SuccessMessage<String[]>("上传文件成功", documentService.parseFile(multipartFile, type)).getMessage();
        } catch (Exception e) {
            System.out.println(e);
            return new ErrorMessage("上传文件失败").getMessage();
        }
    }
}
