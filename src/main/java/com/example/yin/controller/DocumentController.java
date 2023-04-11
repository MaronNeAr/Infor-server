package com.example.yin.controller;

import com.example.yin.config.common.ErrorMessage;
import com.example.yin.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class DocumentController {
    @Autowired
    DocumentService documentService;

    @PostMapping("/document")
    public Object uploadDocument(@RequestParam("file") MultipartFile file, HttpServletRequest req) throws IOException {
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")), text;
        if (suffix.equals("docx")) text = documentService.parseWord(file);
        else if (suffix.equals("pdf")) text = documentService.parsePdf(file);
        else if (suffix.equals("md")) text = documentService.parseMD(file);
        else if (suffix.equals("html")) text = documentService.parseHtml(file);
        else if (suffix.equals("txt")) text = documentService.parseTxt(file);
        else return new ErrorMessage("仅支持txt、html、markdown、docx、pdf格式文档");
        return null;
    }
}
