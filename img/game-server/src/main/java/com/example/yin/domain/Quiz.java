package com.example.yin.domain;

public class Quiz {
    Integer id;

    String content;

    String left;

    String right;

    Integer answer;

    Integer level;

    public Quiz() {
    }

    public Quiz(Integer id, String content, String left, String right, Integer answer, Integer level) {
        this.id = id;
        this.content = content;
        this.left = left;
        this.right = right;
        this.answer = answer;
        this.level = level;
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

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", left='" + left + '\'' +
                ", right='" + right + '\'' +
                ", answer=" + answer +
                ", level=" + level +
                '}';
    }
}
