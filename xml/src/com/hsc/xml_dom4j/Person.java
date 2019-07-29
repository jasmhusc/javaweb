package com.hsc.xml_dom4j;
/**
 * 联系人实体类
 */
public class Person {
    private int id;
    private String name;
    private String  gender;
    private boolean vip;

    public Person() {
    }

    public Person(int id, String name, String gender, boolean vip) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.vip = vip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", vip=" + vip +
                '}';
    }
}
