package com.example.yin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.config.common.ErrorMessage;
import com.example.yin.config.common.SuccessMessage;
import com.example.yin.pojo.Card.*;
import com.example.yin.pojo.vo.CardDefine;
import com.example.yin.service.AuthService;
import com.example.yin.service.CardService;
import com.example.yin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;

@RestController
public class CardController {
    @Autowired
    CardService cardService;

    @Autowired
    ImageService imageService;

    @GetMapping("/card/{uid}")
    public Object getUserCard(@PathVariable Integer uid) {
        return new SuccessMessage<CardDefine>("获取成功",cardService.getAllCardsByUid(uid)).getMessage();
    }

    @PostMapping("/card/{uid}")
    public Object addCard(@PathVariable Integer uid, HttpServletRequest req) throws IOException {
        if (req.getParameter("type") == null || req.getParameter("image") == null) return new ErrorMessage("参数缺失");
        String AT = AuthService.getAuth("GlFznjpVS6AQsa9PxmP8DkD9", "hrO15EH2n97jSqHkbjSaix5tnIqkf45k");
        byte [] image = Base64.getDecoder().decode(req.getParameter("image"));
        String type = req.getParameter("type");
        if (type.equals("idCardBack")) {
            JSONObject json = imageService.idCardRecognize(image, "back", AT);
            String failureDate = (String) json.getJSONObject("words_result").getJSONObject("失效日期").get("words");
            String issueAuthority = (String) json.getJSONObject("words_result").getJSONObject("签发机关").get("words");
            String issueDate = (String) json.getJSONObject("words_result").getJSONObject("签发日期").get("words");
            if (cardService.addIdCardFront(new IdCardFront(null, failureDate, issueAuthority, issueDate, uid))) return new SuccessMessage("添加成功", null);
            else return new ErrorMessage("服务器内部错误");
        } else if (type.equals("idCardFront")) {
            JSONObject json = imageService.idCardRecognize(image, "front", AT);
            String name = (String) json.getJSONObject("words_result").getJSONObject("姓名").get("words");
            String nationality = (String) json.getJSONObject("words_result").getJSONObject("民族").get("words");
            String address = (String) json.getJSONObject("words_result").getJSONObject("住址").get("words");
            String idNumber = (String) json.getJSONObject("words_result").getJSONObject("公民身份号码").get("words");
            String birth = (String) json.getJSONObject("words_result").getJSONObject("出生").get("words");
            Boolean sex = json.getJSONObject("words_result").getJSONObject("性别").get("words").equals("男");
            if (cardService.addIdCardBack(new IdCardBack(null, name, nationality, address, idNumber, birth, sex, uid))) return new SuccessMessage("添加成功", null);
            else return new ErrorMessage("服务器内部错误");
        } else if (type.equals("bankCard")) {
            JSONObject json = imageService.bankCardRecognize(image, AT);
            String validDate = (String) json.getJSONObject("result").get("valid_date");
            String bankCardNumber = (String) json.getJSONObject("result").get("bank_card_number");
            String bankName = (String) json.getJSONObject("result").get("bank_name");
            Integer bankCardType = (Integer) json.getJSONObject("result").get("bank_card_type");
            String holderName = (String) json.getJSONObject("result").get("MR.CHENTA");
            if (cardService.addBankCard(new BankCard(null, validDate, bankCardNumber, bankName, bankCardType, holderName, uid))) return new SuccessMessage("添加成功", null);
            else return new ErrorMessage("服务器内部错误");
        } else if (type.equals("businessLicense")) {
            JSONObject json = imageService.businessLicenseRecognize(image, AT);
            String businessScope = (String) json.getJSONObject("words_result").getJSONObject("经营范围").get("words");
            String organizationType = (String) json.getJSONObject("words_result").getJSONObject("组成形式").get("words");
            String legalPerson = (String) json.getJSONObject("words_result").getJSONObject("法人").get("words");
            String certificateNumber = (String) json.getJSONObject("words_result").getJSONObject("证件编号").get("words");
            String registerCapital = (String) json.getJSONObject("words_result").getJSONObject("注册资本").get("words");
            String unitName = (String) json.getJSONObject("words_result").getJSONObject("单位名称").get("words");
            String validityPeriod = (String) json.getJSONObject("words_result").getJSONObject("有效期").get("words");
            String creditCode = (String) json.getJSONObject("words_result").getJSONObject("社会信用代码").get("words");
            String paidCapital = (String) json.getJSONObject("words_result").getJSONObject("实收资本").get("words");
            String approvalDate = (String) json.getJSONObject("words_result").getJSONObject("核准日期").get("words");
            String establishDate = (String) json.getJSONObject("words_result").getJSONObject("成立日期").get("words");
            String taxNumber = (String) json.getJSONObject("words_result").getJSONObject("税务登记号").get("words");
            String address = (String) json.getJSONObject("words_result").getJSONObject("地址").get("words");
            String registerAuthority = (String) json.getJSONObject("words_result").getJSONObject("登记机关").get("words");
            String v_type = (String) json.getJSONObject("words_result").getJSONObject("类型").get("words");
            if (cardService.addBusinessLicense(new BusinessLicense(null, businessScope, organizationType, legalPerson,
                    certificateNumber, registerCapital, unitName, validityPeriod, creditCode, paidCapital,
                    approvalDate, establishDate, taxNumber, address, registerAuthority, v_type, uid))) return new SuccessMessage("添加成功", null);
            else return new ErrorMessage("服务器内部错误");
        } else if (type.equals("passport")) {
            JSONObject json = imageService.passportRecognize(image, AT);
            String name = (String) json.getJSONObject("words_result").getJSONObject("姓名").get("words");
            String namePinyin = (String) json.getJSONObject("words_result").getJSONObject("姓名拼音").get("words");
            String sex = (String) json.getJSONObject("words_result").getJSONObject("性别").get("words");
            String birth = (String) json.getJSONObject("words_result").getJSONObject("生日").get("words");
            String nationality = (String) json.getJSONObject("words_result").getJSONObject("国籍").get("words");
            String birthPlace = (String) json.getJSONObject("words_result").getJSONObject("出生地点").get("words");
            String issuePlace = (String) json.getJSONObject("words_result").getJSONObject("护照签发地点").get("words");
            String issueAuthority = (String) json.getJSONObject("words_result").getJSONObject("签发机关").get("words");
            String issueDate = (String) json.getJSONObject("words_result").getJSONObject("签发日期").get("words");
            String validUntil = (String) json.getJSONObject("words_result").getJSONObject("有效期至").get("words");
            String countryCode = (String) json.getJSONObject("words_result").getJSONObject("国家码").get("words");
            String MRZcode1 = (String) json.getJSONObject("words_result").getJSONObject("MRZCode1").get("words");
            String MRZcode2 = (String) json.getJSONObject("words_result").getJSONObject("MRZCode2").get("words");
            if (cardService.addPassport(new Passport(null, name, namePinyin, sex, birth, nationality, birthPlace, issuePlace,
                    issueAuthority, issueDate, validUntil, countryCode, MRZcode1, MRZcode2, uid))) return new SuccessMessage("添加成功", null);
            else return new ErrorMessage("服务器内部错误");
        } else if (type.equals("registerBooklet")) {
            JSONObject json = imageService.registerBookletRecognize(image, AT);
            String name = (String) json.getJSONObject("words_result").getJSONObject("Name").get("words");
            String sex = (String) json.getJSONObject("words_result").getJSONObject("Sex").get("words");
            String nation = (String) json.getJSONObject("words_result").getJSONObject("Nation").get("words");
            String hometown = (String) json.getJSONObject("words_result").getJSONObject("Hometown").get("words");
            String cardNo = (String) json.getJSONObject("words_result").getJSONObject("CardNo").get("words");
            String relationship = (String) json.getJSONObject("words_result").getJSONObject("Relationship").get("words");
            String birthday = (String) json.getJSONObject("words_result").getJSONObject("Birthday").get("words");
            String birthPlace = (String) json.getJSONObject("words_result").getJSONObject("BirthAddress").get("words");
            String education = (String) json.getJSONObject("words_result").getJSONObject("Education").get("words");
            String height = (String) json.getJSONObject("words_result").getJSONObject("Height").get("words");
            String workPlace = (String) json.getJSONObject("words_result").getJSONObject("WorkAddress").get("words");
            String householdNum = (String) json.getJSONObject("words_result").getJSONObject("HouseholdNum").get("words");
            String WWHere = (String) json.getJSONObject("words_result").getJSONObject("WWHere").get("words");
            String WWToCity = (String) json.getJSONObject("words_result").getJSONObject("WWToCity").get("words");
            String date = (String) json.getJSONObject("words_result").getJSONObject("Date").get("words");
            if (cardService.addRegisterBooklet(new RegisterBooklet(null,name, sex, nation, hometown, cardNo, relationship,
                    birthday, birthPlace, education, height, workPlace, householdNum, WWHere, WWToCity, date, uid))) return new SuccessMessage("添加成功", null);
            else return new ErrorMessage("服务器内部错误");
        } else return new ErrorMessage("其他证件暂未开发");
    }
}