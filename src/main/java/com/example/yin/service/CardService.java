package com.example.yin.service;

import com.example.yin.dao.CardMappers.*;
import com.example.yin.pojo.Card.*;
import com.example.yin.pojo.vo.CardDefine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    BankCardMapper bankCardMapper;

    @Autowired
    BusinessLicenseMapper businessLicenseMapper;

    @Autowired
    IdCardBackMapper idCardBackMapper;

    @Autowired
    IdCardFrontMapper idCardFrontMapper;

    @Autowired
    PassportMapper passportMapper;

    @Autowired
    RegisterBookletMapper registerBookletMapper;

    public CardDefine getAllCardsByUid(Integer uid) {
        return new CardDefine(bankCardMapper.selectBankCardByUid(uid),
                businessLicenseMapper.selectBusinessLicenseByUid(uid),
                idCardBackMapper.selectIdCardBackByUid(uid),
                idCardFrontMapper.selectIdCardFrontByUid(uid),
                passportMapper.selectPassportByUid(uid),
                registerBookletMapper.selectRegisterBookletByUid(uid));
    }

    public IdCardBack getIdCardBackByUid(Integer uid) {
        return idCardBackMapper.selectIdCardBackByUid(uid);
    }

    public IdCardFront getIdCardFrontByUid(Integer uid) {
        return idCardFrontMapper.selectIdCardFrontByUid(uid);
    }

    public BankCard getBankCardByUid(Integer uid) {
        return bankCardMapper.selectBankCardByUid(uid);
    }

    public BusinessLicense getBusinessLicenseByUid(Integer uid) {
        return businessLicenseMapper.selectBusinessLicenseByUid(uid);
    }

    public Passport getPassportByUid(Integer uid) {
        return passportMapper.selectPassportByUid(uid);
    }

    public RegisterBooklet getRegisterBookletByUid(Integer uid) {
        return registerBookletMapper.selectRegisterBookletByUid(uid);
    }

    public Boolean addIdCardBack(IdCardBack idCardBack) {
        if (idCardBackMapper.selectIdCardBackByUid(idCardBack.getUid()) == null) return idCardBackMapper.insertIdCardBack(idCardBack) > 0;
        else return idCardBackMapper.updateIdCardBack(idCardBack) > 0;
    }

    public Boolean addIdCardFront(IdCardFront idCardFront) {
        if (idCardFrontMapper.selectIdCardFrontByUid(idCardFront.getUid()) == null) return idCardFrontMapper.insertIdCardFront(idCardFront) > 0;
        else return idCardFrontMapper.updateIdCardFront(idCardFront) > 0;
    }

    public Boolean addBankCard(BankCard bankCard) {
        if (bankCardMapper.selectBankCardByUid(bankCard.getUid()) == null) return bankCardMapper.insertBankCard(bankCard) > 0;
        else return bankCardMapper.updateBankCard(bankCard) > 0;
    }

    public Boolean addBusinessLicense(BusinessLicense businessLicense) {
        if (businessLicenseMapper.selectBusinessLicenseByUid(businessLicense.getUid()) == null) return businessLicenseMapper.insertBusinessLicense(businessLicense) > 0;
        else return businessLicenseMapper.updateBusinessLicense(businessLicense) > 0;
    }

    public Boolean addPassport(Passport passport) {
        if (passportMapper.selectPassportByUid(passport.getUid()) == null) return passportMapper.insertPassport(passport) > 0;
        else return passportMapper.updatePassport(passport) > 0;
    }

    public Boolean addRegisterBooklet(RegisterBooklet registerBooklet) {
        if (registerBookletMapper.selectRegisterBookletByUid(registerBooklet.getUid()) == null) return registerBookletMapper.insertRegisterBooklet(registerBooklet) > 0;
        else return registerBookletMapper.updateRegisterBooklet(registerBooklet) > 0;
    }
}