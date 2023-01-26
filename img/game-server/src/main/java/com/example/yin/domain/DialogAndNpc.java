package com.example.yin.domain;

public class DialogAndNpc {
    Integer id;

    String content;

    Integer nid;

    String tag;

    Integer index;

    String name;

    Integer age;

    String sex;

    String img;

    public DialogAndNpc() {
    }

    public DialogAndNpc(Integer id, String content, Integer nid, String tag, Integer index, String name, Integer age, String sex, String img) {
        this.id = id;
        this.content = content;
        this.nid = nid;
        this.tag = tag;
        this.index = index;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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
        return "DialogAndNpc{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", nid=" + nid +
                ", tag='" + tag + '\'' +
                ", index=" + index +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
