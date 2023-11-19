package com.codeup.codeupspringblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {


    @GetMapping("/posts")
    public String getIndexPage(Model model) {
        Post post1 = new Post("The greatest Coffee tragedy of all time ", "This morning I was making coffee and I forgot to put the coffee pot under the coffee maker. I made a huge mess.");
        Post post2 = new Post("Traveling to the moon", "I am going to the moon next week. I am very excited about it.");
        List<Post> posts = new ArrayList<>();
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getSinglePost(Model model, @PathVariable String id) {

        Post post = new Post("title", "body");
        model.addAttribute("post", post);
        return "posts/show";

    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String getCreatePostForm() {
        return "view the form for creating a post";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }

}
