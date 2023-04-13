package com.example.yin.controller;

import com.example.yin.config.common.ErrorMessage;
import com.example.yin.config.common.SuccessMessage;
import com.example.yin.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/file")
    public Object uploadDocument(@RequestParam("file") MultipartFile file, @RequestParam("type") String type, @RequestParam("id") String id) throws IOException {
        try {
            fileService.writeToFile("document/" + type + "/" + id + "." + type, file);
            return new SuccessMessage("上传文件成功").getMessage();
        } catch (Exception e) {
            System.out.println(e);
            return new ErrorMessage("上传文件失败").getMessage();
        }
    }
}
