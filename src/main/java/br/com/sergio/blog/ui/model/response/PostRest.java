package br.com.sergio.blog.ui.model.response;

import br.com.sergio.blog.io.entity.UserEntity;

public class PostRest {

    private String postId;
    private String title;
    private String text;
    private UserEntity author;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
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
