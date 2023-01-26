package com.example.yin.pojo.vo;

public class UserDefine {
    Integer id;

    String nickname;

    String phone;

    String email;

    String wechatId;

    public UserDefine() {
    }

    public UserDefine(Integer id, String nickname, String phone, String email, String wechatId) {
        this.id = id;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.wechatId = wechatId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    @Override
    public String toString() {
        return "UserDefine{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", wechatId='" + wechatId + '\'' +
                '}';
    }
}
