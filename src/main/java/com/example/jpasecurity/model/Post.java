package com.example.jpasecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String slug;
    private String content;
    private String auth;
    private LocalDateTime publishedOn;
    private LocalDateTime updatedOn;

    public Post(){}

    public Post(String title, String slug, String content, String auth) {
        this.title = title;
        this.slug = slug;
        this.content = content;
        this.auth = auth;
        this.publishedOn=LocalDateTime.now();
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getSlug() {return slug;}
    public void setSlug(String slug) {this.slug = slug;}

    public String getContent() {return content;}
    public void setContent(String content) {this.content = content;}

    public String getAuth() {return auth;}
    public void setAuth(String auth) {this.auth = auth;}

    public LocalDateTime getPublishedOn() {return publishedOn;}
    public void setPublishedOn(LocalDateTime publishedOn) {this.publishedOn = publishedOn;}

    public LocalDateTime getUpdatedOn() {return updatedOn;}
    public void setUpdatedOn(LocalDateTime updatedOn) {this.updatedOn = updatedOn;}


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", content='" + content + '\'' +
                ", auth='" + auth + '\'' +
                ", publishedOn=" + publishedOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
