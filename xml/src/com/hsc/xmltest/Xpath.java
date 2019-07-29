package com.hsc.xmltest;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import java.io.File;
import java.util.List;

public class Xpath {
    @Test
    public void Xparser() {
        try {
            Document document = new SAXReader().read(new File("F:\\idea\\javaweb\\xml\\src\\xml\\stus1.xml"));
            List<Node> nodeList = document.selectNodes("/stus/stu/name");
            for ( Node node : nodeList) {
                System.out.println(node.getName() +":"+node.getText());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
