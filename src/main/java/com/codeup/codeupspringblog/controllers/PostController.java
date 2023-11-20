package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {


    @GetMapping()
    public String getIndexPage(Model model) {
        Post post1 = new Post(1, "Blog Post #1", "This is a blog post.");
        Post post2 = new Post(2, "Blog Post #2", "This is another blog post");
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    //handles the GET request for one single post
    @GetMapping("/{id}")
    public String getSinglePost(Model model, @PathVariable String id) {
        //method to get post by id
        Post post = new Post(1, "Blog Post #1", "This is a blog post.");
        model.addAttribute("post", post);
        return "posts/show";

    }


    //handles the GET request for the form
    @GetMapping("/create")
    public String getCreatePostForm() {

        return "posts/create";
    }


    //handles the POST request for the form
// get the post data from the from // use it to create a new post object //then add the post object to the model
// then return the view for the single post
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPost(Model model, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        Post post = new Post(1, title, body);
        model.addAttribute("post", post);
        return "/{id}";
    }

}
