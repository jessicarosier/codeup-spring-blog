package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HelloController {

    @GetMapping("/hello/{name}")
    @ResponseBody

    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }


}
