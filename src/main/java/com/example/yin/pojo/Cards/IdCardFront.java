package com.example.yin.pojo.Cards;

public class IdCardFront {
    Integer id;

    String failureDate;

    String issueAuthority;

    String issueDate;

    Integer uid;

    public IdCardFront() {
    }

    public IdCardFront(Integer id, String failureDate, String issueAuthority, String issueDate, Integer uid) {
        this.id = id;
        this.failureDate = failureDate;
        this.issueAuthority = issueAuthority;
        this.issueDate = issueDate;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFailureDate() {
        return failureDate;
    }

    public void setFailureDate(String failureDate) {
        this.failureDate = failureDate;
    }

    public String getIssueAuthority() {
        return issueAuthority;
    }

    public void setIssueAuthority(String issueAuthority) {
        this.issueAuthority = issueAuthority;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "IdCardFront{" +
                "id=" + id +
                ", failureDate='" + failureDate + '\'' +
                ", issueAuthority='" + issueAuthority + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", uid=" + uid +
                '}';
    }
}
