package com.codeup.codeupspringblog.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    long id;

    @Column(name="username", length = 250)
    String username;

    @Column(name="first_name", length = 250)
    String firstName;

    @Column(name="last_name", length = 250)
    String lastName;

    @Column(name="email", length = 250)
    String email;

    @Column(name="password", length = 500)
    String password;

    // ONE USER CAN HAVE MANY POSTS
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;


    // ONE USER CAN HAVE MANY COMMENTS
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comment> comments;


    @Entity
    @Table(name = "users")
    public class User {
        /* ... */

        public User(User copy) {
            id = copy.id; // This line is SUPER important! Many things won't work if it's absent
            email = copy.email;
            username = copy.username;
            password = copy.password;
        }
    }



    public User() {
    }

    public User(long id, String username, String firstName, String lastName, String email, String password, List<Post> posts, List<Comment> comments) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.posts = posts;
        this.comments = comments;
    }

    public User(long id, String username, String firstName, String lastName, String email, String password, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public User(long id, String username, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(String username, String firstName, String lastName, String email, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
