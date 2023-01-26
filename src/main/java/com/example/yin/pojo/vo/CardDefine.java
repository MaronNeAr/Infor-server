package com.example.yin.pojo.vo;

import com.example.yin.pojo.Card.*;

public class CardDefine {
    BankCard bankCard;

    BusinessLicense bussinessLiense;

    IdCardBack idCardBack;

    IdCardFront idCardFront;

    Passport passport;

    RegisterBooklet registerBooklet;

    public CardDefine(BankCard bankCard, BusinessLicense bussinessLiense, IdCardBack idCardBack, IdCardFront idCardFront, Passport passport, RegisterBooklet registerBooklet) {
        this.bankCard = bankCard;
        this.bussinessLiense = bussinessLiense;
        this.idCardBack = idCardBack;
        this.idCardFront = idCardFront;
        this.passport = passport;
        this.registerBooklet = registerBooklet;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public BusinessLicense getBussinessLiense() {
        return bussinessLiense;
    }

    public void setBussinessLiense(BusinessLicense bussinessLiense) {
        this.bussinessLiense = bussinessLiense;
    }

    public IdCardBack getIdCardBack() {
        return idCardBack;
    }

    public void setIdCardBack(IdCardBack idCardBack) {
        this.idCardBack = idCardBack;
    }

    public IdCardFront getIdCardFront() {
        return idCardFront;
    }

    public void setIdCardFront(IdCardFront idCardFront) {
        this.idCardFront = idCardFront;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public RegisterBooklet getRegisterBooklet() {
        return registerBooklet;
    }

    public void setRegisterBooklet(RegisterBooklet registerBooklet) {
        this.registerBooklet = registerBooklet;
    }

    @Override
    public String toString() {
        return "CardDefine{" +
                "bankCard=" + bankCard +
                ", bussinessLiense=" + bussinessLiense +
                ", idCardBack=" + idCardBack +
                ", idCardFront=" + idCardFront +
                ", passport=" + passport +
                ", registerBooklet=" + registerBooklet +
                '}';
    }
}
