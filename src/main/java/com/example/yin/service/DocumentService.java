package com.example.yin.service;
import com.example.yin.api.JsonRequest;
import com.example.yin.dao.DocumentMapper;
import com.example.yin.pojo.Doc;
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

import java.io.IOException;
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

    public String[] parseFile(MultipartFile file, String type) throws IOException {
        try {
            String text = null;
            if (type.equals("docx")) text = parseWord(file);
            else if (type.equals("pdf")) text = parsePdf(file);
            else if (type.equals("md")) text = parseMD(file);
            else if (type.equals("txt")) text = parseTxt(file);
            else if (type.equals("html")) text = parseHtml(file);
            else return new String[2];
            return new String[]{getSummary(text), getTags(text)};
        } catch (Exception e) {
            System.out.println(e);
            return new String[2];
        }
    }

    public String getSummary(String text) throws Exception {
        String baiduCloudUrl = "https://aip.baidubce.com/rpc/2.0/nlp/v1/news_summary?charset=UTF-8&access_token=" + AuthService.getAuth();
        JsonRequest request = new JsonRequest(baiduCloudUrl);
        request.addParam("title", "title");
//        request.addParam("content", "麻省理工学院的研究团队为无人机在仓库中使用RFID技术进行库存查找等工作，创造了一种聪明的新方式。它允许公司使用更小，更安全的无人机在巨型建筑物中找到之前无法找到的东西。使用RFID标签更换仓库中的条形码，将帮助提升自动化并提高库存管理的准确性。与条形码不同，RFID标签不需要对准扫描，标签上包含的信息可以更广泛和更容易地更改。它们也可以很便宜，尽管有优点，但是它具有局限性，对于跟踪商品没有设定RFID标准，“标签冲突”可能会阻止读卡器同时从多个标签上拾取信号。扫描RFID标签的方式也会在大型仓库内引起尴尬的问题。固定的RFID阅读器和阅读器天线只能扫描通过设定阈值的标签，手持式读取器需要人员出去手动扫描物品。几家公司已经解决了无人机读取RFID的技术问题。配有RFID读卡器的无人机可以代替库存盘点的人物，并以更少的麻烦更快地完成工作。一个人需要梯子或电梯进入的高箱，可以通过无人机很容易地达到，无人机可以被编程为独立地导航空间，并且他们比执行大规模的重复任务的准确性和效率要比人类更好。目前市场上的RFID无人机需要庞大的读卡器才能连接到无人机的本身。这意味着它们必须足够大，以支持附加硬件的尺寸和重量，使其存在坠机风险。麻省理工学院的新解决方案，名为Rfly，允许无人机阅读RFID标签，而不用捆绑巨型读卡器。相反，无人机配备了一个微小的继电器，它像Wi-Fi中继器一样。无人机接收从远程RFID读取器发送的信号，然后转发它读取附近的标签。由于继电器很小，这意味着可以使用更小巧的无人机，可以使用塑料零件，可以适应较窄的空间，不会造成人身伤害的危险。麻省理工学院的Rfly系统本质上是对现有技术的一个聪明的补充，它不仅消除了额外的RFID读取器，而且由于它是一个更轻的解决方案，允许小型无人机与大型无人机做同样的工作。研究团队正在马萨诸塞州的零售商测试该系统。");
        request.addParam("content", text.substring(0, 2000));
        request.addParam("max_summary_len", 200);
        return request.send();
    }

    public String getTags(String text) throws Exception {
        String baiduCloudUrl = "https://aip.baidubce.com/rpc/2.0/nlp/v1/keyword?charset=UTF-8&access_token=" + AuthService.getAuth();
        JsonRequest request = new JsonRequest(baiduCloudUrl);
        request.addParam("title", "title");
        request.addParam("content", text.substring(0, 2000));
        return request.send();
    }
}
