package com.example.yin.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Resume {
    Integer id;
    String name;
    String countryCode;
    String phone;
    String email;
    String identificationType;
    String idCode;
    String city;
    String college;
    String degree;
    String major;
    String eduStartDate;
    String eduEndDate;
    String internCompany;
    String internCareer;
    String internDesc;
    String internStartDate;
    String internEndDate;
    String productName;
    String productRole;
    String productUrl;
    String productDesc;
    String selfSkill;
    String selfEvaluate;
    String account;

    public Resume(Integer id, String name, String countryCode, String phone, String email, String identificationType, String idCode, String city, String college, String degree, String major, String eduStartDate, String eduEndDate, String internCompany, String internCareer, String internDesc, String internStartDate, String internEndDate, String productName, String productRole, String productUrl, String productDesc, String selfSkill, String selfEvaluate, String account) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.phone = phone;
        this.email = email;
        this.identificationType = identificationType;
        this.idCode = idCode;
        this.city = city;
        this.college = college;
        this.degree = degree;
        this.major = major;
        this.eduStartDate = eduStartDate;
        this.eduEndDate = eduEndDate;
        this.internCompany = internCompany;
        this.internCareer = internCareer;
        this.internDesc = internDesc;
        this.internStartDate = internStartDate;
        this.internEndDate = internEndDate;
        this.productName = productName;
        this.productRole = productRole;
        this.productUrl = productUrl;
        this.productDesc = productDesc;
        this.selfSkill = selfSkill;
        this.selfEvaluate = selfEvaluate;
        this.account = account;
    }
}


