package com.codeup.codeupspringblog.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    long id;


    @Column(name = "username", length = 250, unique = true)
    private String username;

    @Column(name = "first_name", length = 250)
    @NotEmpty(message = "First name cannot be blank")
    private String firstName;

    @Column(name = "last_name", length = 250)
    @NotEmpty(message = "Last name cannot be blank")
    private String lastName;

    @Column(name = "email", length = 250, unique = true)
    @NotEmpty(message = "Email cannot be blank")
    @Email(message = "Please provide a valid email")
    private String email;

    @Column(name = "password", length = 500)
    @JsonIgnore
    @NotEmpty(message = "Password cannot be blank")
    private String password;

    @Column(name = "avatar", length = 500)
    private String avatar;



    // ONE USER CAN HAVE MANY POSTS
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonBackReference
    private List<Post> posts;


    // ONE USER CAN HAVE MANY COMMENTS
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonBackReference
    private List<Comment> comments;


    @ManyToMany(mappedBy = "likedBy")
    @JsonIgnore
    private Set<Post> likedPosts = new HashSet<>();

    public User() {

    }

//AUTHENTICATION CONSTRUCTOR
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        username = copy.username;
        email = copy.email;
        password = copy.password;
        firstName = copy.firstName;
        lastName = copy.lastName;
        avatar = copy.avatar;
        posts = copy.posts;
        comments = copy.comments;
        likedPosts = copy.likedPosts;
    }


    public User(long id, String username, String firstName, String lastName, String email, String password, String avatar, List<Post> posts, List<Comment> comments, Set<Post> likedPosts) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.posts = posts;
        this.comments = comments;
        this.likedPosts = likedPosts;
    }

    public User(long id, String username, String firstName, String lastName, String email, String password, String avatar, List<Post> posts, List<Comment> comments) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.posts = posts;
        this.comments = comments;
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

    public User(String username, String firstName, String lastName, String email, String password, String avatar, List<Post> posts, List<Comment> comments) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.posts = posts;
        this.comments = comments;
    }

    public User(String username, String firstName, String lastName, String email, String password, String avatar) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public Set<Post> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(Set<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }
}
