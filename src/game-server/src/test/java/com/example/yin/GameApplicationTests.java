package com.example.yin;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.api.HttpRequest;
import com.example.yin.dao.DialogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GameApplicationTests {

    @Autowired
    DialogMapper dialogMapper;

    @Test
    public void test02() throws IOException {
        System.out.println(dialogMapper.getDialogAndNpcByTag("test"));
    }
}
