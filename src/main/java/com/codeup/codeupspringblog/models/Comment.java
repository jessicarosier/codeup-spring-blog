package com.codeup.codeupspringblog.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    long id;

    @Column(name = "body", length = 500)
    String body;

    // MANY COMMENTS CAN BELONG TO ONE USER
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private User user;


    // MANY COMMENTS CAN BELONG TO ONE POST
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "post_id")
    private Post post;


    public Comment(long id, String body, User user, Post post) {
        this.id = id;
        this.body = body;
        this.user = user;
        this.post = post;
    }

    public Comment(long id, String body, User user) {
        this.id = id;
        this.body = body;
        this.user = user;
    }

    public Comment(long id, String body) {
        this.id = id;
        this.body = body;
    }

    public Comment(String body) {
        this.body = body;
    }

    public Comment() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
