package com.hpw.message.tool;

import com.hpw.message.entity.Result;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class SendSoap {
    public Result send(String url1, String soap) {
        Document reqDoc = null;
        Result result = new Result();
        result.setMsg("发送失败");
        result.setCode("1");
        try {
            URL url = new URL(url1);
            URLConnection c = url.openConnection();
            c.setUseCaches(false);
            c.setDoInput(true);
            c.setDoOutput(true);
            c.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
            OutputStream os = c.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
            osw.write(soap);
            osw.flush();
            osw.close();
            InputStream is = c.getInputStream();
            reqDoc = openXmlDocument(is);
            if(reqDoc.asXML().contains("发送成功")) {
                result.setCode("0");
                result.setMsg("发送成功");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 从InputStream中读取Document对象
     *
     * @param in
     * @return
     */
    public static Document openXmlDocument(InputStream in) {
        Document resDoc = null;

        SAXReader reader = new SAXReader();
        try {
            return reader.read(in);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return resDoc;
    }

}
