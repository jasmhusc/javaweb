package com.hsc.xml_dom4j;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.util.ArrayList;
import java.util.List;

public class Person_dom4j {
    public static void main(String[] args) {

        // 得到family.xml的根元素
        try {
            Element rootElement = new SAXReader().read(Person_dom4j.class.getResourceAsStream("/com/hsc/xml/family.xml")).getRootElement();
            // 获得所有person，遍历
            List<Element> persons = rootElement.elements("person");

            // 创建集合，添加进集合中
            ArrayList<Person> list = new ArrayList<>();

            for (Element person : persons) {
                // 获取每个person的id,name,gender和vip
                String name = person.elementText("name");
                boolean vip = Boolean.parseBoolean(person.attributeValue("vip"));
                String gender = person.elementText("gender");
                int id = Integer.parseInt(person.attributeValue("id"));

                // 创建对象
                list.add(new Person(id,name,gender,vip));
            }

            // 遍历集合，打印元素
            list.forEach(System.out::println);
        } catch (DocumentException e) {
            System.out.println("解析失败！");
        }

    }
}
