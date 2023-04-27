package com.example.yin.controller;

import com.example.yin.config.common.ErrorMessage;
import com.example.yin.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @PostMapping("/document")
    public Object uploadDocument(HttpServletRequest req) throws IOException {
        return null;
    }
}
