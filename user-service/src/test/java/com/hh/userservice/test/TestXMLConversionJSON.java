package com.hh.userservice.test;

import com.alibaba.fastjson.JSONObject;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestXMLConversionJSON
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/5/19 16:15
 * @Version 1.0
 **/
public class TestXMLConversionJSON {

    @Test
    public void testJsonData() {
        JSONObject obj = new JSONObject();
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "\t<a>\n" +
                "\t\t<e>\n" +
                "\t\t\t<name>zhangsan</name>\n" +
                "\t\t\t<age>19</age>\n" +
                "\t\t</e>\n" +
                "\t\t<e>\n" +
                "\t\t\t<name>wangwu</name>\n" +
                "\t\t\t<age>12</age>\n" +
                "\t\t</e>\n" +
                "\t\t<e>\n" +
                "\t\t\t<like>basketball</like>\n" +
                "\t\t\t<sex>1</sex>\n" +
                "\t\t</e>\n" +
                "\t</a>\n";
        try {
            InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));
            SAXBuilder sb = new SAXBuilder();
            Document doc = sb.build(is);
            Element root = doc.getRootElement();
            obj.put(root.getName(), iterateElement(root));
            System.out.println(obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private static Map iterateElement(Element element) {
        List jiedian = element.getChildren();
        Element et = null;
        Map obj = new HashMap();
        List list = null;
        for (int i = 0; i < jiedian.size(); i++) {
            list = new LinkedList();
            et = (Element) jiedian.get(i);
            if (et.getTextTrim().equals("")) {
                if (et.getChildren().size() == 0)
                    continue;
                if (obj.containsKey(et.getName())) {
                    list = (List) obj.get(et.getName());
                }
                list.add(iterateElement(et));
                obj.put(et.getName(), list);
            } else {
                if (obj.containsKey(et.getName())) {
                    list = (List) obj.get(et.getName());
                }
                list.add(et.getTextTrim());
                obj.put(et.getName(), list);
            }
        }
        return obj;
    }

}
