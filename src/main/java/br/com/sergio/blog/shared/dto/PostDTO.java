package br.com.sergio.blog.shared.dto;

import br.com.sergio.blog.io.entity.UserEntity;

import java.io.Serializable;

public class PostDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String postId;
    private String title;
    private String text;
    private UserEntity author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setUserId(String userId) {
        this.postId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }
}
