package com.example.yin.domain;

public class Npc {
    Integer id;

    String name;

    Integer age;

    String sex;

    String img;

    public Npc() {
    }

    public Npc(Integer id, String name, Integer age, String sex, String img) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Npc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
