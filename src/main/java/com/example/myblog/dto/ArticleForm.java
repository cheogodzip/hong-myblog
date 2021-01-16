package com.example.myblog.dto;

public class ArticleForm {
    private String title;
    private String content;
    private String writer;
    public ArticleForm(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
