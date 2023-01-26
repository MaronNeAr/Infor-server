package com.example.yin.pojo.Card;

public class Passport {
    Integer id;

    String name;

    String namePinyin;

    String sex;

    String birth;

    String nationality;

    String birthPlace;

    String issuePlace;

    String issueAuthority;

    String issueDate;

    String validUntil;

    String countryCode;

    String MRZcode1;

    String MRZcode2;

    Integer uid;

    public Passport() {
    }

    public Passport(Integer id, String name, String namePinyin, String sex, String birth, String nationality, String birthPlace, String issuePlace, String issueAuthority, String issueDate, String validUntil, String countryCode, String MRZcode1, String MRZcode2, Integer uid) {
        this.id = id;
        this.name = name;
        this.namePinyin = namePinyin;
        this.sex = sex;
        this.birth = birth;
        this.nationality = nationality;
        this.birthPlace = birthPlace;
        this.issuePlace = issuePlace;
        this.issueAuthority = issueAuthority;
        this.issueDate = issueDate;
        this.validUntil = validUntil;
        this.countryCode = countryCode;
        this.MRZcode1 = MRZcode1;
        this.MRZcode2 = MRZcode2;
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

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public String getIssueAuthority() {
        return issueAuthority;
    }

    public void setIssueAuthority(String issueAuthority) {
        this.issueAuthority = issueAuthority;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMRZcode1() {
        return MRZcode1;
    }

    public void setMRZcode1(String MRZcode1) {
        this.MRZcode1 = MRZcode1;
    }

    public String getMRZcode2() {
        return MRZcode2;
    }

    public void setMRZcode2(String MRZcode2) {
        this.MRZcode2 = MRZcode2;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", namePinyin='" + namePinyin + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", issuePlace='" + issuePlace + '\'' +
                ", issueAuthority='" + issueAuthority + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", validUntil='" + validUntil + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", MRZcode1='" + MRZcode1 + '\'' +
                ", MRZcode2='" + MRZcode2 + '\'' +
                ", uid=" + uid +
                '}';
    }
}
