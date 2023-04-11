package com.example.yin.service;
import java.io.IOException;

import com.example.yin.dao.ResumeMapper;
import com.example.yin.pojo.Resume;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    @Autowired
    ResumeMapper resumeMapper;

    public Resume getResume(String account) {
        return resumeMapper.selectResumeByAccount(account);
    }

    public boolean updateResume(Resume resume) {
        String account = resume.getAccount();
        if (getResume(account) == null) return resumeMapper.insertResume(resume) > 0;
        else return resumeMapper.updateResume(resume) > 0;
    }

    public String resumeAnalysis (String fname, String fdate) throws JSONException, IOException {
        HttpPost httpPost = new HttpPost("http://resumesdk.market.alicloudapi.com/ResumeParser");
        httpPost.setHeader("Authorization", "APPCODE " + "9d4335acb2ad4e31b291480df3294bc6");
        httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");
        httpPost.addHeader("Content-Type", "application/json");

        // 设置内容信息
        JSONObject json = new JSONObject();
        json.put("file_name", fname + ".pdf");	// 文件名
        json.put("file_cont", fdate);	// 经base64编码过的文件内容
        json.put("need_avatar", 0);		// 是否需要解析头像
        json.put("ocr_type", 1);		// 1为高级ocr
        StringEntity params = new StringEntity(json.toString(), Consts.UTF_8);
        httpPost.setEntity(params);

        // 发送请求
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(httpPost);

        // 处理返回结果
        String resCont = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
        return resCont;
    }
}
