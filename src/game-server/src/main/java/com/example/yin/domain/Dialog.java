package com.example.yin.domain;

public class Dialog {
    Integer id;

    String content;

    Integer nid;

    String tag;

    Integer index;

    public Dialog() {
    }

    public Dialog(Integer id, String content, Integer nid, String tag, Integer index) {
        this.id = id;
        this.content = content;
        this.nid = nid;
        this.tag = tag;
        this.index = index;
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

    @Override
    public String toString() {
        return "Dialog{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", nid=" + nid +
                ", tag='" + tag + '\'' +
                ", index=" + index +
                '}';
    }
}
