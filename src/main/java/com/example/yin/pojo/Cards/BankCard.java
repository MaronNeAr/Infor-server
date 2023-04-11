package com.example.yin.pojo.Cards;

public class BankCard {
    Integer id;

    String validDate;

    String bankCardNumber;

    String bankName;

    Integer bankCardType;

    String holderName;

    Integer uid;

    public BankCard() {
    }

    public BankCard(Integer id, String validDate, String bankCardNumber, String bankName, Integer bankCardType, String holderName, Integer uid) {
        this.id = id;
        this.validDate = validDate;
        this.bankCardNumber = bankCardNumber;
        this.bankName = bankName;
        this.bankCardType = bankCardType;
        this.holderName = holderName;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer bankCardType() {
        return bankCardType;
    }

    public void bankCardType(Integer bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                ", validDate='" + validDate + '\'' +
                ", bankCardNumber='" + bankCardNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankCardType=" + bankCardType +
                ", holderName='" + holderName + '\'' +
                ", uid=" + uid +
                '}';
    }
}
