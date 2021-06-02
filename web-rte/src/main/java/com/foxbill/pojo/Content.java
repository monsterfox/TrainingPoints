package com.foxbill.pojo;

public class Content {
    private int id;
    private String content;

    public Content() {
    }

    public Content(String content) {
        this.content = content;
    }

    public Content(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
