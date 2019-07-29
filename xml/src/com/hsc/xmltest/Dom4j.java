package com.hsc.xmltest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Dom4j {
    @Test
    public void parser(){

        try{
            //1. 创建sax读取对象
            SAXReader reader = new SAXReader(); //jdbc -- classloader
            //2. 指定解析的xml源
            Document document = reader.read(Dom4j.class.getResourceAsStream("/com/hsc/xml/stus.xml"));
            //Document document  = reader.read(new File("F:\\idea\\javaweb\\xml\\src\\xml\\stus.xml"));

            //3. 得到元素、
            //得到根元素
            Element rootElement= document.getRootElement();

            //获取根元素下面的子元素 age
            //rootElement.element("age")
            //System.out.println(rootElement.element("stu").element("age").getText());

            //获取根元素下面的所有子元素 。 stu元素
            List<Element> elements = rootElement.elements();
            //遍历所有的stu元素
            for (Element element : elements) {
                //获取stu元素下面的name元素
                String name = element.element("name").getText();
                String age = element.element("age").getText();
                String sex = element.element("sex").getText();
                System.out.println("name="+name+"==age+"+age+"==sex="+sex);
            }
            System.out.println("");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void parserpro(){
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(new File("F:\\idea\\javaweb\\xml\\src\\xml\\stus2.xml"));
            Element stus = doc.getRootElement();

            for(Iterator i=stus.elementIterator(); i.hasNext();){
                Element user=(Element) i.next();
                for(Iterator j = user.elementIterator(); j.hasNext();){
                    //System.out.println(((Element) j.next()).getName()+":"+((Element) j.next()).getText());
                    Element node = (Element) j.next();
                    System.out.println(node.getName() +":"+node.getText());

                    //这里不能用下面这种写法来表示，我觉得可能是读取速度的问题
                    // System.out.println((Element) j.next().getName() + ":" + node.getText());

                }
                System.out.println();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
