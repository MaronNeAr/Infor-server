package com.example.yin;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.dao.CardMappers.BankCardMapper;
import com.example.yin.dao.CardMappers.BusinessLicenseMapper;
import com.example.yin.dao.CardMappers.IdCardBackMapper;
import com.example.yin.dao.CardMappers.IdCardFrontMapper;
import com.example.yin.dao.UserMapper;
import com.example.yin.pojo.Card.BankCard;
import com.example.yin.service.AuthService;
import com.example.yin.service.ImageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Autowired
    BankCardMapper bankCardMapper;

    @Autowired
    BusinessLicenseMapper businessLicenseMapper;

    @Autowired
    IdCardBackMapper idCardBackMapper;

    @Autowired
    IdCardFrontMapper idCardFrontMapper;



    @Test
    public void test02() throws IOException {
        ImageService imageService = new ImageService();
        FileInputStream file = new FileInputStream("img/sfzTest.jpg");
        byte[] data = new byte[file.available()];
        file.read(data);
        file.close();
        JSONObject json = imageService.idCardRecognize(data,"back", "24.74b070ccb54c5606b3ec2c6dcb8b1f0f.2592000.1676883641.282335-28383447");
        System.out.println(json);
        System.out.println(json.getJSONObject("words_result").getJSONObject("失效日期").get("words"));
    }

    @Test
    public void test01() throws IOException {
        String AT = AuthService.getAuth("GlFznjpVS6AQsa9PxmP8DkD9", "hrO15EH2n97jSqHkbjSaix5tnIqkf45k");
        System.out.println(AT);
        //24.6606660f36f1356ef42b1497c2f584bb.2592000.1670824750.282335-28383447
    }

    @Test
    public void test03() throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        String plainText = "Hello, World!";
        String key = "sufe-computer-20";
        String iv = "abcdefghijklmnop";

        byte[] plainTextBytes = plainText.getBytes(StandardCharsets.UTF_8);
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        byte[] ivBytes = iv.getBytes(StandardCharsets.UTF_8);

        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivParameter = new IvParameterSpec(ivBytes);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameter);

        byte[] encryptedBytes = cipher.doFinal(plainTextBytes);

        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        byte[] encryBytes = Base64.getDecoder().decode(encryptedText);

        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameter);

        byte[] textBytes = cipher.doFinal(encryBytes);
        String text = new String(textBytes, StandardCharsets.UTF_8);
        System.out.println("Plain Text: " + text);
    }

    @Test
    public void test04() {
        BankCard bankCard = new BankCard(null, "123", "123", "123", 2, "123", 2);
        bankCardMapper.insertBankCard(bankCard);
        System.out.println(bankCardMapper.selectBankCardByUid(2));
        BankCard newBankCard = new BankCard(null, "456", "456", "456", 2, "456", 2);
        bankCardMapper.updateBankCard(newBankCard);
        System.out.println(bankCardMapper.selectBankCardByUid(2));
    }

    @Test
    public void test05() {
        BankCard bankCard = new BankCard(null, "123", "123", "123", 2, "123", 2);
        bankCardMapper.insertBankCard(bankCard);
        System.out.println(bankCardMapper.selectBankCardByUid(2));
        BankCard newBankCard = new BankCard(null, "456", "456", "456", 2, "456", 2);
        bankCardMapper.updateBankCard(newBankCard);
        System.out.println(bankCardMapper.selectBankCardByUid(2));
    }
}
