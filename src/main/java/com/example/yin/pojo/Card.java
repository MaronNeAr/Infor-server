package com.example.yin.pojo;

import lombok.Data;

@Data
public class Card {
    Integer id;
    String type;
    String detail;
    String src;
    String account;

    public Card(Integer id, String type, String detail, String src, String account) {
        this.id = id;
        this.type = type;
        this.detail = detail;
        this.src = src;
        this.account = account;
    }
}
