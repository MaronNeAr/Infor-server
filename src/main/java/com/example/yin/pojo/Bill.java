package com.example.yin.pojo;

import lombok.Data;

@Data
public class Bill {
    Integer id;
    String type;
    String title;
    String detail;
    String date;
    String tags;
    String note;
    String src;
    String account;

    public Bill(Integer id, String type, String title, String detail, String date, String src, String account) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.date = date;
        this.src = src;
        this.account = account;
    }

    public Bill(Integer id, String type, String title, String detail, String date, String tags, String note, String src, String account) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.detail = detail;
        this.date = date;
        this.tags = tags;
        this.note = note;
        this.src = src;
        this.account = account;
    }
}
