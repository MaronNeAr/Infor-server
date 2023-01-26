package com.example.yin.service;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.api.HttpRequest;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class ImageService {
    public JSONObject idCardRecognize(byte[] image, String side, String at) throws UnsupportedEncodingException {
        String urlString = URLEncoder.encode(new BASE64Encoder().encode(image), "GBK");
        JSONObject json = JSONObject.parseObject(
                HttpRequest.sendPost("https://aip.baidubce.com/rest/2.0/ocr/v1/idcard?access_token=" + at,
                        "image=" + urlString + "&id_card_side=" + side)
        );
        return json;
    }

    public JSONObject bankCardRecognize(byte[] image, String at) throws UnsupportedEncodingException {
        String urlString = URLEncoder.encode(new BASE64Encoder().encode(image), "GBK");
        JSONObject json = JSONObject.parseObject(
                HttpRequest.sendPost("https://aip.baidubce.com/rest/2.0/ocr/v1/bankcard?access_token=" + at,
                        "image=" + urlString)
        );
        return json;
    }

    public JSONObject businessLicenseRecognize(byte[] image, String at) throws UnsupportedEncodingException {
        String urlString = URLEncoder.encode(new BASE64Encoder().encode(image), "GBK");
        JSONObject json = JSONObject.parseObject(
                HttpRequest.sendPost("https://aip.baidubce.com/rest/2.0/ocr/v1/business_license?access_token=" + at,
                        "image=" + urlString)
        );
        return json;
    }

    public JSONObject passportRecognize(byte[] image, String at) throws UnsupportedEncodingException {
        String urlString = URLEncoder.encode(new BASE64Encoder().encode(image), "GBK");
        JSONObject json = JSONObject.parseObject(
                HttpRequest.sendPost("https://aip.baidubce.com/rest/2.0/ocr/v1/passport?access_token=" + at,
                        "image=" + urlString)
        );
        return json;
    }

    public JSONObject registerBookletRecognize(byte[] image, String at) throws UnsupportedEncodingException {
        String urlString = URLEncoder.encode(new BASE64Encoder().encode(image), "GBK");
        JSONObject json = JSONObject.parseObject(
                HttpRequest.sendPost("https://aip.baidubce.com/rest/2.0/ocr/v1/household_register?access_token=" + at,
                        "image=" + urlString)
        );
        return json;
    }
}
