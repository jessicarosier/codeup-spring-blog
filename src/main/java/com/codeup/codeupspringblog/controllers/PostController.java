package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/posts")
public class PostController {


    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    //Above: set up a number of fields for our repositories


    //Below: Normal mapping and methods for GET and POST requests
    @GetMapping()
    public String getIndexPage(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    //handles the GET request for one single post
    @GetMapping("/{id}")
    public String getSinglePost(Model model, @PathVariable long id) {

        model.addAttribute("post", postDao.getPostById(id));
        return "posts/show";

    }


    //handles the GET request for the form
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

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deletePost(Model model, @RequestParam(name="id") long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

}
