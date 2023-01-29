package com.example.yin.service;

import org.springframework.stereotype.Service;

import java.io.*;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentService {
    public String parseWord(MultipartFile multipartFile) throws IOException {
        XWPFDocument doc = new XWPFDocument(multipartFile.getInputStream());
        XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
        String text = extractor.getText();
        return text;
    }

    public String parsePdf(MultipartFile multipartFile) throws IOException {
        File file = new File("document/test.txt");
        multipartFile.transferTo(file);
        PDDocument document = PDDocument.load(file);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        document.close();
        return text;
    }

    public String parseMD(MultipartFile multipartFile) throws IOException {
        byte[] encoded = multipartFile.getBytes();
        String markdown = new String(encoded);
        Parser parser = Parser.builder().build();
        Node node = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String html = renderer.render(node);
        return Jsoup.parse(html).text();
    }

    public String parseHtml(MultipartFile multipartFile) throws IOException {
        File file = new File("document/test.txt");
        multipartFile.transferTo(file);
        Document html = Jsoup.parse(file, "UTF-8", "");
        return html.text();
    }

    public String parseTxt(MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(isr);
        String line, str = "";
        while ((line = br.readLine()) != null) {
            str += '\n' + line;
        }
        br.close();
        isr.close();
        inputStream.close();
        return str;
    }
}
