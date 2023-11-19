package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class PostController {

//    Edit your PostController class to return the views index and show
//    Inside the method that shows an individual post, create a new post object and pass it to the view.
//    Inside the method that shows all the posts, create a new array list and add two post objects to it, then pass that list to the view.
//    In these two pages, you should display information based on the data passed from the controller.



    @GetMapping("/posts")
    @ResponseBody
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String getSinglePost(Model model) {

        Post post = new Post("title", "body");
        model.addAttribute("post", post);
        return "show";

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
