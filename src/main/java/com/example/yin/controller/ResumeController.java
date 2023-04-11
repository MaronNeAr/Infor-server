package com.example.yin.controller;

import com.example.yin.config.common.ErrorMessage;
import com.example.yin.config.common.SuccessMessage;
import com.example.yin.constant.Constants;
import com.example.yin.pojo.Resume;
import com.example.yin.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;

@RestController
public class ResumeController {
    @Autowired
    ResumeService resumeService;

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/document/**")
                    .addResourceLocations(Constants.RESUMES_PATH);
        }
    }

    @PostMapping("/resume")
    public Object getResume(HttpServletRequest req) {
        try {
            String account = req.getParameter("account");
            if (account == null) return new ErrorMessage("缺少参数").getMessage();
            else return new SuccessMessage<Resume>("获取简历信息成功", resumeService.getResume(account)).getMessage();
        } catch (Exception e) {
            System.out.println(e);
            return new ErrorMessage("获取简历信息失败").getMessage();
        }
    }

    @PostMapping("/resume/save")
    public Object saveResume(HttpServletRequest req) {
        try {
            String account = req.getParameter("account");
            if (account == null) return new ErrorMessage("缺少参数").getMessage();
            String name = req.getParameter("name");
            String countryCode = req.getParameter("countryCode");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String identificationType = req.getParameter("identificationType");
            String idCode = req.getParameter("idCode");
            String city = req.getParameter("city");
            String college = req.getParameter("college");
            String degree = req.getParameter("degree");
            String major = req.getParameter("major");
            String eduStartDate = req.getParameter("eduStartDate");
            String eduEndDate = req.getParameter("eduEndDate");
            String internCompany = req.getParameter("internCompany");
            String internCareer = req.getParameter("internCareer");
            String internDesc = req.getParameter("internDesc");
            String internStartDate = req.getParameter("internStartDate");
            String internEndDate = req.getParameter("internEndDate");
            String productName = req.getParameter("productName");
            String productRole = req.getParameter("productRole");
            String productUrl = req.getParameter("productUrl");
            String productDesc = req.getParameter("productDesc");
            String selfSkill = req.getParameter("selfSkill");
            String selfEvaluate = req.getParameter("selfEvaluate");
            boolean flag = resumeService.updateResume(new Resume(null, name, countryCode, phone, email, identificationType, idCode, city, college, degree, major, eduStartDate, eduEndDate, internCompany, internCareer, internDesc, internStartDate, internEndDate, productName, productRole, productUrl, productDesc, selfSkill, selfEvaluate, account));
            if (flag) return new SuccessMessage("更新简历成功").getMessage();
            else return new ErrorMessage("更新简历失败").getMessage();
        } catch (Exception e) {
            System.out.println(e);
            return new ErrorMessage("更新简历失败").getMessage();
        }
    }

    @PostMapping("/resume/upload")
    public Object uploadResume(@RequestParam("file") MultipartFile file) throws IOException {
        try {
            String base64Encoded = Base64.getEncoder().encodeToString(file.getBytes());
            return new SuccessMessage<String>("解析简历成功", resumeService.resumeAnalysis(file.getName(), base64Encoded)).getMessage();
        } catch(Exception e) {
            System.out.println(e);
            return new ErrorMessage("解析简历失败").getMessage();
        }
    }
}
