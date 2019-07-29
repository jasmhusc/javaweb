package com.hsc.xml_xpath;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

public class Xml_xpath {
    static Document document;
    @BeforeClass
    public static void getDocument() throws Exception {

        // 获取document对象
        document = new SAXReader().read(Xml_xpath.class.getResourceAsStream("/com/hsc/xml/family.xml"));
//        System.out.println("document = " + document);
    }

    @Test
    public void getSingleNode(){
        // 得到：name==冰冰
        Node name = document.selectSingleNode("/persons/name");
        System.out.println("name = " + name.getText());
    }

    @Test
    public void getSingleNode2(){
        /*
        用相对路径获取：斯嘉丽
         */
        // 先得到那个person
        String xpath1 = "persons/children/person";
        Node person = document.selectSingleNode(xpath1);
        // 进一步得到name
        String xpath2 = "./oop/name";
        Node name = person.selectSingleNode(xpath2);
        System.out.println(name.getText());

        // 这样越级更简单
        System.out.println(document.selectSingleNode("//oop/name").getText());
    }

    @Test
    public void getNames(){
        // 定义xpath路径，单/表示不能越级
        String xpath = "/persons/person/name";
        // 获取满足条件的name
        List<Node> nodes = document.selectNodes(xpath);
        // 遍历所有name的内容Text
        for (Node node : nodes) {
            System.out.println("name = " + node.getText());
        }
    }

    @Test
    public void getAllNames(){
        /*
         得到整个document下所有name，需要越级，用//
          */
        String xpath = "//name";
        List<Node> nodes = document.selectNodes(xpath);
        for (Node node : nodes) {
            System.out.println("name = "+ node.getName() +"     text = " + node.getText());
        }
    }

    @Test
    public void getAttaributes(){
        /*
         a. 得到某个属性:
            //@ 属性名
         b. 获取包含" 属性名"的所有元素:
            //元素[@ 属性名]
         c. 获取包含" 属性名= 值"的所有元素：
            //元素[@ 属性名=' 值']
          */
        // 1. 得到所有id
        List<Node> nodes = document.selectNodes("//@id");
        for (Node node : nodes) {
            System.out.println("node = " + node.getText());
        }
        System.out.println("------------");

        // 2. 得到包含id 属性的person对象:// 元素[@ 属性名]
        List<Node> nodeList = document.selectNodes("//person[@id]");
        for (Node node : nodeList) {
            Element p = (Element) node;
            // 获取该person的id
            System.out.println("id = " + p.attributeValue("id"));
        }
        System.out.println("------------");

        // 3. 得到包含某个属性，且指定属性值的所有元素
        Element p = (Element) document.selectSingleNode("//person[@id='103']");
        System.out.println("id = " + p.attributeValue("id"));
    }
}
