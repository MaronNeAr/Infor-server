package com.example.yin.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.config.common.ErrorMessage;
import com.example.yin.config.common.SuccessMessage;
import com.example.yin.constant.Constants;
import com.example.yin.pojo.Bill;
import com.example.yin.pojo.vo.CardDefine;
import com.example.yin.service.AuthService;
import com.example.yin.service.BillService;
import com.example.yin.service.FileService;
import com.example.yin.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class BillController {
    @Autowired
    BillService billService;

    @Autowired
    ImageService imageService;

    @Autowired
    FileService fileService;

    @PostMapping("/bill")
    public Object getUserCard(HttpServletRequest req) {
        try {
            String account = req.getParameter("account");
            String type = req.getParameter("type");
            if (account == null) return new ErrorMessage("参数缺失").getMessage();
            else if (type == null) return new SuccessMessage<List<Bill>>("获取卡证数据成功", billService.getBill(account)).getMessage();
            else return new SuccessMessage<Bill>("获取卡证数据成功", billService.getBill(account, type)).getMessage();
        } catch (Exception e) {
            System.out.println(e);
            return new ErrorMessage("获取卡证数据失败").getMessage();
        }
    }

    @PostMapping("/bill/update")
    public Object addCard(@RequestParam("account") String account, @RequestParam("type") String type, @RequestParam("title") String title, @RequestParam("file") MultipartFile file) {
        try {
            if (account == null || type == null|| file == null) return new ErrorMessage("缺少参数").getMessage();
            String base64Encoded = Base64.getEncoder().encodeToString(file.getBytes());
            UUID uuid = UUID.fromString(UUID.randomUUID().toString());
            String path = uuid + ".jpg";
            fileService.writeToFile("img/" + path, file);
            String image = URLEncoder.encode(base64Encoded, "GBK");
            String res = type.equals("other") ? null : imageService.billRecognize(image, type);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = dateFormat.format(new Date());
            billService.updateBill(new Bill(null, type, title, res, formattedDate, path, account));
            return new SuccessMessage<String>("添加/更新票据数据成功", res).getMessage();
        } catch (IOException e) {
            System.out.println(e);
            return new ErrorMessage("添加/更新票据数据失败").getMessage();
        }
    }

    @PostMapping("/bill/modify")
    public Object modifyTagsAndNote(HttpServletRequest req) {
        try {
            String id = req.getParameter("id");
            String tags = req.getParameter("tags");
            String note = req.getParameter("note");
            if (id == null || tags == null || note == null) return new ErrorMessage("缺少参数").getMessage();
            boolean flag = billService.updateTagsAndNoteByBid(Integer.valueOf(id), tags, note);
            if (flag) return new SuccessMessage("修改标签/笔记成功").getMessage();
            else return new ErrorMessage("修改标签/笔记失败").getMessage();
        } catch (Exception e) {
            System.out.println(e);
            return new ErrorMessage("修改标签/笔记失败").getMessage();
        }
    }
}