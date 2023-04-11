package com.example.yin.service;

import com.example.yin.dao.DocumentMapper;
import com.example.yin.pojo.Doc;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.springframework.beans.factory.annotation.Autowired;
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

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentService {
    @Autowired
    DocumentMapper documentMapper;

    public List<Doc> getDocuments(String account) {
        return documentMapper.selectFilesByAccount(account);
    }

    public boolean addDocument(Doc document) {
        return documentMapper.insertFile(document) > 0;
    }

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

    public String getSummary(String text) {
//        Analyzer analyzer = new SimpleAnalyzer();
//        TokenStream tokenStream = analyzer.tokenStream("field", new StringReader(text));
//        tokenStream.reset();
//        List<String> tokens = new ArrayList<>();
//        while (tokenStream.incrementToken()) {
//            CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
//            tokens.add(charTermAttribute.toString());
//        }
//        tokenStream.close();
//        Query query = new TermQuery(new Term("field", text));
//        SimpleHTMLFormatter formatter = new SimpleHTMLFormatter();
//        QueryScorer scorer = new QueryScorer(query, "field");
//        Highlighter highlighter = new Highlighter(formatter, scorer);
//        String summary = highlighter.getBestFragment(analyzer, "field", text);
//        if (summary == null || summary.length() < maxLength) {
//            return null;
//        }
        return "";
    }
}
