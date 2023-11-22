package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@Controller
@RequestMapping("/posts")
public class PostController {

    // DEPENDENCY INJECTION

    private final EmailService emailService;

    private final PostRepository postDao;

    private final UserRepository userDao;

    // INSTANTIATES NEW REPOSITORIES WHICH ARE USED TO ACCESS THE DATABASE
    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }


    //  GET ALL POSTS
    @GetMapping()
    public String getIndexPage(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    // GET SINGLE POST
    @GetMapping("/{id}")
    public String getSinglePost(Model model, @PathVariable long id) {
        Post post = postDao.getPostById(id);
        model.addAttribute("post", post);
        return "posts/show";

    }

    // CREATE POSTS
    @GetMapping("/create")
    public String getCreatePostForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post) {
        User user = userDao.getUserById(1L);
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(post, "New Post", "Check out this new post!");
        return "redirect:/posts";
    }

    //    DELETE POSTS
    @PostMapping("/delete")
    public String deletePost(@RequestParam(name = "id") long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }


    //    EDIT POSTS
    @GetMapping("/edit/{id}")
    public String getEditPostForm(Model model, @PathVariable long id) {
        model.addAttribute("post", postDao.getPostById(id));
        return "posts/edit";
    }


    @PostMapping("/edit")
    public String editPost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

    /* LIKE POSTS / when form is submitted, it will send the
     id of the post to this mapping so we can add the user to
      the likedBy set */
    @PostMapping("/like")
    public String likePost(@RequestParam(name = "id") long id) {
        Post post = postDao.getPostById(id);
      // TODO: Refactor - get the user that is logged in
        User user = userDao.getUserById(1L);
        post.getLikedBy().add(user);
        postDao.save(post);
        return "redirect:/posts/" + id;
    }

    /* UNLIKE POSTS / when form is submitted, it will send the
     id of the post to this mapping so we can remove the user from
      the likedBy set */
    @PostMapping("/unlike")
    public String unlikePost(@RequestParam(name = "id") long id) {
        Post post = postDao.getPostById(id);
        // TODO: Refactor - get the user that is logged in
        User user = userDao.getUserById(1L);
        post.getLikedBy().remove(user);
        postDao.save(post);
        return "redirect:/posts/" + id;
    }

    /* GET LIST OF USERS THAT LIKED A POST AND GIVE IT TO THE FRONTEND*/

    @GetMapping("/posts.json")
    public @ResponseBody List<Post> viewAllPostsInJSONFormat() {
        return postDao.findAll();
    }

    @GetMapping("/posts.json/{id}")
    public @ResponseBody List<Post> viewAllPostsInJSONFormat(@PathVariable long id) {
        return postDao.findAllById(Collections.singleton(id));
    }

    @GetMapping("/posts/ajax")
    public String viewAllPostsInAJAXFormat() {
        return "posts/ajax";
    }


    @GetMapping("/posts/ajax/{id}.json")
    public @ResponseBody Post viewSinglePostInJSONFormat(@PathVariable long id) {
        return postDao.getPostById(id);
    }


}
