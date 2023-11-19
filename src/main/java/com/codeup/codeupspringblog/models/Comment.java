package com.codeup.codeupspringblog.models;

public class Comment {

    long id;

    long post_id;

    long user_id;

    String body;

    public Comment(long id, long post_id, long user_id, String body) {
        this.id = id;
        this.post_id = post_id;
        this.user_id = user_id;
        this.body = body;
    }

    public Comment() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
