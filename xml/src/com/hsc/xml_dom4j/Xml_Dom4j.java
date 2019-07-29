package com.hsc.xml_dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

public class Xml_Dom4j {
    static Document document;

    @BeforeClass
    public static void getDocument() throws Exception {
        /**
         * 得到文档对象
         */
        // 创建SaxReader对象
        SAXReader reader = new SAXReader();
        // 获取Inputstream
//        InputStream in = new FileInputStream("F:/idea/javaweb/xml/src/com/hsc/xml/books.xml");
        InputStream in = Xml_Dom4j.class.getResourceAsStream("/com/hsc/xml/books.xml");
        // 获得Document对象
        document = reader.read(in);
//        System.out.println("document = " + document);
    }

    @Test
    public void getElement() throws Exception {
        // 获取根元素
        Element rootElement = document.getRootElement();
        System.out.println(rootElement);

        // String getName() 得到标签名字
        System.out.println(rootElement.getName());

        // Element element(name)  获得指定名字的元素对象，默认为第一个book。
        Element book = rootElement.element("book");
        System.out.println(book.getName());

        // List<Element> elements()  获得book元素下所有的子元素对象，即所有book
        List<Element> elements = book.elements();
        elements.forEach(System.out::println);

        // List<Element> elements(name)  获得所有book元素对象，根元素下只有book。
        List<Element> booklist = rootElement.elements("book");
        booklist.forEach(b -> System.out.println(b.getName()));
    }

    @Test
    public void getAttribute(){
        /**
         * 先得到元素，再才能得到属性，1，2都可以得到属性值；
         *
         */
        Element root = document.getRootElement();
        Element firstbook = root.element("book");

        // 1. Attribute attribute(name)  根据属性名获得一个属性对象
        Attribute id = firstbook.attribute("id");
        System.out.println(id);
        System.out.println(id.getName() + "::" + id.getValue());

        // 2. String attributeValue(name)  根据属性名获得属性值，返回字符串
        String value = firstbook.attributeValue("vip");
        System.out.println("vip = " + value);

        // 3.得到某个元素所有属性名称和值
        List<Attribute> list = firstbook.attributes();
        list.forEach(attr -> System.out.println("属性名称："+attr.getName()+"，  属性值："+attr.getValue()));
    }

    public void getText(){
        /**
         * 获取元素内的文本内容
         */
        Element book = document.getRootElement().element("book");

        // 得到第1个book的信息:String getText()
        System.out.println(book.getText());

        // 得到子元素name的文本内容
        String name = book.elementText("name");
        System.out.println("name = " + name);

        // String elementTextTrim( 元素名)，去掉前后的空格
        String date = book.elementTextTrim("date");
    }
}
