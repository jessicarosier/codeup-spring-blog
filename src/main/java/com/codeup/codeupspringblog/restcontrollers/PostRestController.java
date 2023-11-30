package com.codeup.codeupspringblog.restcontrollers;


import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class PostRestController {


    private final PostRepository postDao;

    public PostRestController(PostRepository postDao) {
        this.postDao = postDao;

    }

    @GetMapping("/api/posts")
    public @ResponseBody List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        return postDao.findAll();

    }


    //returns a list of users who have liked a post
    @GetMapping("/api/posts/likes" + "/{id}")
    public @ResponseBody List<User> getPostLikes(@PathVariable long id) {
        List<User> users = new ArrayList<>();
        Post post = postDao.getOne(id);
        Set<User> likedBy = post.getLikedBy();
        for (User user : likedBy) {
            users.add(user);
        }
        return users;
    }

    //get most liked posts
    @GetMapping("/api/posts/likes")
    public @ResponseBody List<Post> getMostLikedPosts() {
        List<Post> posts = new ArrayList<>();
        return postDao.findAllByOrderByLikedByDesc();
    }


    //get most recent posts
    @GetMapping("/api/posts/recent")
    public @ResponseBody List<Post> getMostRecentPosts() {
        List<Post> posts = new ArrayList<>();
        return postDao.findAllByOrderByCreatedAtDesc();
    }
}
