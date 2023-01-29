package com.example.yin;

import com.alibaba.fastjson.JSONObject;
import com.example.yin.dao.CardMappers.BankCardMapper;
import com.example.yin.dao.CardMappers.BusinessLicenseMapper;
import com.example.yin.dao.CardMappers.IdCardBackMapper;
import com.example.yin.dao.CardMappers.IdCardFrontMapper;
import com.example.yin.dao.UserMapper;
import com.example.yin.pojo.Card.BankCard;
import com.example.yin.service.AuthService;
import com.example.yin.service.DocumentService;
import com.example.yin.service.ImageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.search.similarities.TFIDFSimilarity;
import org.wltea.analyzer.lucene.IKAnalyzer;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InforApplicationTests {
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

    @Autowired
    DocumentService documentService;



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

    @Test
    public void test06() throws IOException {
        FileInputStream fis = new FileInputStream("document/基于BERT-IT的世界杯球队图像识别模型.docx");
        XWPFDocument doc = new XWPFDocument(fis);
        XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
        String text1 = extractor.getText();
        System.out.println(text1);
        fis.close();

        // Load the PDF document
        PDDocument document = PDDocument.load(new File("document/《数字化生存》读后感.pdf"));
        // Instantiate PDFTextStripper
        PDFTextStripper pdfStripper = new PDFTextStripper();
        // Extract text from PDF
        String text2 = pdfStripper.getText(document);
        System.out.println(text2);
        // Close the document
        document.close();

        // Read markdown file
        byte[] encoded = Files.readAllBytes(Paths.get("document/数据库原理提纲.md"));
        String markdown = new String(encoded);
        // Parse markdown to AST
        Parser parser = Parser.builder().build();
        Node node = parser.parse(markdown);
        // Render HTML from AST
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String html = renderer.render(node);
        System.out.println(Jsoup.parse(html).text());

        File input = new File("document/code.html");
        Document html_doc = Jsoup.parse(input, "UTF-8", "");
        System.out.println(html_doc.text());

        Path path = Paths.get("document/“卷乎”产品与服务.txt");
        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    @Test
    public void Test07() throws IOException {
        File file = new File("document/数据库原理提纲.md");
        MockMultipartFile multipartFile = new MockMultipartFile("file", file.getName(), MediaType.MULTIPART_FORM_DATA_VALUE, new FileInputStream(file));
        System.out.println(documentService.parseMD(multipartFile));
    }

    @Test
    public void Test08() throws IOException {
        String text = "这是一段需要摘要的文本...";
        IKAnalyzer analyzer = new IKAnalyzer();
        String summary = Summarizer.summarize(text, analyzer, 5);
    }
}
