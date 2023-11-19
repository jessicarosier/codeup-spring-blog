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


    @GetMapping
    public String getIndexPage(Model model) {
        Post post1 = new Post(1, "The greatest Coffee tragedy of all time ", "This morning I was making coffee and I forgot to put the coffee pot under the coffee maker. I made a huge mess.");
        Post post2 = new Post(2, "Traveling to the moon", "I am going to the moon next week. I am very excited about it.");
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
       Post post = new Post(1, "The greatest Coffee tragedy of all time ", "This morning I was making coffee and I forgot to put the coffee pot under the coffee maker. I made a huge mess.");
        model.addAttribute("post", post);
        return "posts/show";

    }


    //handles the GET request for the form
    @GetMapping("/create")
    public String getCreatePostForm() {

        return "posts/create";
    }


    //handles the POST request for the form
    @RequestMapping(value = "/create", method = RequestMethod.POST)

    public String createPost() {
        return "/posts/create";
    }

}
