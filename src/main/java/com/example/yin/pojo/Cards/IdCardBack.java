package com.example.yin.pojo.Cards;

public class IdCardBack {
    Integer id;

    String name;

    String nationality;

    String address;

    String idNumber;

    String birth;

    Boolean sex;

    Integer uid;

    public IdCardBack() {
    }

    public IdCardBack(Integer id, String name, String nationality, String address, String idNumber, String birth, Boolean sex, Integer uid) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.address = address;
        this.idNumber = idNumber;
        this.birth = birth;
        this.sex = sex;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String idNumber() {
        return idNumber;
    }

    public void idNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "IdCardBack{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", address='" + address + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", birth='" + birth + '\'' +
                ", sex=" + sex +
                ", uid=" + uid +
                '}';
    }
}
