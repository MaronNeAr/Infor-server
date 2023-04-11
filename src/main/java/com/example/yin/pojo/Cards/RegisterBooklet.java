package com.example.yin.pojo.Cards;

public class RegisterBooklet {
    Integer id;

    String name;

    String sex;

    String nation;

    String hometown;

    String cardNo;

    String relationship;

    String birthday;

    String birthPlace;

    String education;

    String height;

    String workPlace;

    String householdNum;

    String WWHere;

    String WWToCity;

    String date;

    Integer uid;

    public RegisterBooklet() {
    }

    public RegisterBooklet(Integer id, String name, String sex, String nation, String hometown, String cardNo, String relationship, String birthday, String birthPlace, String education, String height, String workPlace, String householdNum, String WWHere, String WWToCity, String date, Integer uid) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.hometown = hometown;
        this.cardNo = cardNo;
        this.relationship = relationship;
        this.birthday = birthday;
        this.birthPlace = birthPlace;
        this.education = education;
        this.height = height;
        this.workPlace = workPlace;
        this.householdNum = householdNum;
        this.WWHere = WWHere;
        this.WWToCity = WWToCity;
        this.date = date;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getHouseholdNum() {
        return householdNum;
    }

    public void setHouseholdNum(String householdNum) {
        this.householdNum = householdNum;
    }

    public String getWWHere() {
        return WWHere;
    }

    public void setWWHere(String WWHere) {
        this.WWHere = WWHere;
    }

    public String getWWToCity() {
        return WWToCity;
    }

    public void setWWToCity(String WWToCity) {
        this.WWToCity = WWToCity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "RegisterBooklet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", hometown='" + hometown + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", relationship='" + relationship + '\'' +
                ", birthday='" + birthday + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", education='" + education + '\'' +
                ", height='" + height + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", householdNum='" + householdNum + '\'' +
                ", WWHere='" + WWHere + '\'' +
                ", WWToCity='" + WWToCity + '\'' +
                ", date='" + date + '\'' +
                ", uid=" + uid +
                '}';
    }
}
