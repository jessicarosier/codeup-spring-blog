package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class JoinController {

    @GetMapping("/join")
    public String showJoinForm(Model model) {
        List<String> studentList = new ArrayList<>();
        studentList.add("Jessica");
        studentList.add("Ryan");
        studentList.add("Daniel");
        model.addAttribute("studentList", studentList);
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort",cohort);
        return "join";
    }
}
