package com.example.yin.service;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.api.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImageService {
    private Map<String, String> typeMap = new HashMap<String, String>();

    public ImageService() {
        typeMap.put("idcard-back", "idcard");
        typeMap.put("idcard-front", "idcard");
    }

    public JSONObject idCardRecognize(String image, String side, String at) throws UnsupportedEncodingException {
//        String urlString = URLEncoder.encode(new BASE64Encoder().encode(image), "GBK");
        JSONObject json = JSONObject.parseObject(
                HttpRequest.sendPost("https://aip.baidubce.com/rest/2.0/ocr/v1/idcard?access_token=" + at,
                        "image=" + image + "&id_card_side=" + side)
        );
        System.out.println(json);
        return json;
    }

    public JSONObject bankCardRecognize(String image, String at) throws UnsupportedEncodingException {
//        String urlString = URLEncoder.encode(new BASE64Encoder().encode(image), "GBK");
        JSONObject json = JSONObject.parseObject(
                HttpRequest.sendPost("https://aip.baidubce.com/rest/2.0/ocr/v1/bankcard?access_token=" + at,
                        "image=" + image)
        );
        return json;
    }

    public JSONObject businessLicenseRecognize(String image, String at) throws UnsupportedEncodingException {
//        String urlString = URLEncoder.encode(new BASE64Encoder().encode(image), "GBK");
        JSONObject json = JSONObject.parseObject(
                HttpRequest.sendPost("https://aip.baidubce.com/rest/2.0/ocr/v1/business_license?access_token=" + at,
                        "image=" + image)
        );
        return json;
    }

    public JSONObject passportRecognize(String image, String at) throws UnsupportedEncodingException {
//        String urlString = URLEncoder.encode(new BASE64Encoder().encode(image), "GBK");
        JSONObject json = JSONObject.parseObject(
                HttpRequest.sendPost("https://aip.baidubce.com/rest/2.0/ocr/v1/passport?access_token=" + at,
                        "image=" + image)
        );
        return json;
    }

    public JSONObject registerBookletRecognize(String image, String at) throws UnsupportedEncodingException {
//        String urlString = URLEncoder.encode(new BASE64Encoder().encode(image), "GBK");
        JSONObject json = JSONObject.parseObject(
                HttpRequest.sendPost("https://aip.baidubce.com/rest/2.0/ocr/v1/household_register?access_token=" + at,
                        "image=" + image)
        );
        return json;
    }

    public String cardRecognize(String image, String type, String side) {
        String baiduCloudUrl = "https://aip.baidubce.com/rest/2.0/ocr/v1/" + type + "?access_token=" + AuthService.getAuth();
        return HttpRequest.sendPost(baiduCloudUrl, "image=" + image + (side == null || side.equals("null") ? "" : "&id_card_side=" + side));
    }
}
