package com.codeup.codeupspringblog.models;//package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

@Entity
@Table(name = "blog_posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(name = "title", nullable = false, length = 250)
    private String title;

    @Column(name = "body", length = 250)
    private String body;

    @Column(name="image", length = 500)
    private String image;

    // MANY POSTS CAN BELONG TO ONE USER
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    // ONE POST CAN HAVE MANY COMMENTS
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;


    public Post(long id, String title, String body, String image, User user, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.image = image;
        this.user = user;
        this.comments = comments;
    }

    public Post(long id, String title, String body, User user, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.comments = comments;
    }

    public Post(long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, String image) {
        this.title = title;
        this.body = body;
        this.image = image;
    }

    public Post(String title, String body, String image, User user) {
        this.title = title;
        this.body = body;
        this.image = image;
        this.user = user;
    }

    public Post(String title, String body, String image, User user, List<Comment> comments) {
        this.title = title;
        this.body = body;
        this.image = image;
        this.user = user;
        this.comments = comments;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
