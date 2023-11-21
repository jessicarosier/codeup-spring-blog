package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/posts")
public class PostController {

    // DEPENDENCY INJECTION
    private final PostRepository postDao;

    // INSTANTIATES A NEW POST REPOSITORY WHICH IS USED TO ACCESS THE DATABASE
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
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

        model.addAttribute("post", postDao.getPostById(id));
        return "posts/show";

    }

    // CREATE POSTS

    @GetMapping("/create")
    public String getCreatePostForm() {

        return "posts/create";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPost(Model model, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post post = new Post(title, body);
        model.addAttribute("post", postDao.save(post));

        return "redirect:/posts";
    }

    //    DELETE POSTS
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePost(Model model, @RequestParam(name = "id") long id) {
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
    public String editPost(Model model, @RequestParam(name = "id") long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post post = new Post(id, title, body);
        model.addAttribute("post", postDao.save(post));
        return "redirect:/posts";
    }



}
