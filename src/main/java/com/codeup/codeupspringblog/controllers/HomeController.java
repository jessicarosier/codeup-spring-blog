package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Controller
public class HomeController {

    @GetMapping("/")
    public String displayHome(Model model) {
        return "index";
    }


}
