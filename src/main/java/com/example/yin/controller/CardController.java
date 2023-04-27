package com.example.yin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.config.common.ErrorMessage;
import com.example.yin.config.common.SuccessMessage;
import com.example.yin.constant.Constants;
import com.example.yin.pojo.Card;
import com.example.yin.pojo.Cards.*;
import com.example.yin.pojo.vo.CardDefine;
import com.example.yin.service.AuthService;
import com.example.yin.service.CardService;
import com.example.yin.service.FileService;
import com.example.yin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class CardController {
    @Autowired
    CardService cardService;

    @Autowired
    ImageService imageService;

    @Autowired
    FileService fileService;

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/**")
                    .addResourceLocations(Constants.IMAGES_PATH);
        }
    }

    @PostMapping("/card")
    public Object getUserCard(HttpServletRequest req) {
        try {
            String account = req.getParameter("account");
            String type = req.getParameter("type");
            if (account == null) return new ErrorMessage("参数缺失").getMessage();
            else if (type == null) return new SuccessMessage<List<Card>>("获取卡证数据成功", cardService.getCard(account)).getMessage();
            else return new SuccessMessage<Card>("获取卡证数据成功", cardService.getCard(account, type)).getMessage();
        } catch (Exception e) {
            System.out.println(e);
            return new ErrorMessage("获取卡证数据失败").getMessage();
        }
    }

    @PostMapping("/card/update")
    public Object addCard(@RequestParam("account") String account, @RequestParam("type") String type, @RequestParam("title") String title, @RequestParam("side") String side, @RequestParam("file") MultipartFile file) {
        try {
            if (account == null || type == null || side == null || file == null) return new ErrorMessage("缺少参数").getMessage();
            String base64Encoded = Base64.getEncoder().encodeToString(file.getBytes());
            UUID uuid = UUID.fromString(UUID.randomUUID().toString());
            String path = uuid + ".jpg";
            fileService.writeToFile("img/" + path, file);
            String image = URLEncoder.encode(base64Encoded, "GBK");
            String res = type.equals("other") ? null : imageService.cardRecognize(image, type, side);
//            String res = "test";
            if (!side.equals("null")) type += "-" + side;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(new Date());
            cardService.updateCard(new Card(null, type, title, res, formattedDate, path, account));
            return new SuccessMessage<String>("添加/更新卡证数据成功", res).getMessage();
        } catch (IOException e) {
            System.out.println(e);
            return new ErrorMessage("添加/更新卡证数据失败").getMessage();
        }
    }

    @PostMapping("/card/modify")
    public Object modifyTagsAndNote(HttpServletRequest req) {
        try {
            String id = req.getParameter("id");
            String tags = req.getParameter("tags");
            String note = req.getParameter("note");
            if (id == null || tags == null || note == null) return new ErrorMessage("缺少参数").getMessage();
            boolean flag = cardService.updateTagsAndNoteByBid(Integer.valueOf(id), tags, note);
            if (flag) return new SuccessMessage("修改标签/笔记成功").getMessage();
            else return new ErrorMessage("修改标签/笔记失败").getMessage();
        } catch (Exception e) {
            System.out.println(e);
            return new ErrorMessage("修改标签/笔记失败").getMessage();
        }
    }

    @GetMapping("/cardPrev/{uid}")
    public Object getUserCardPrev(@PathVariable Integer uid) {
        return new SuccessMessage<CardDefine>("获取成功",cardService.getAllCardsByUid(uid)).getMessage();
    }

    @PostMapping("/cardPrev/{uid}")
    public Object addCardPrev(@PathVariable Integer uid, HttpServletRequest req) throws IOException {
        if (req.getParameter("type") == null || req.getParameter("image") == null) return new ErrorMessage("参数缺失");
        String AT = AuthService.getAuth("GlFznjpVS6AQsa9PxmP8DkD9", "hrO15EH2n97jSqHkbjSaix5tnIqkf45k");
//        String image = URLDecoder.decode(req.getParameter("image"), "GBK");
        String image = URLEncoder.encode(req.getParameter("image"), "GBK");
        String type = req.getParameter("type");
        System.out.println(image);
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