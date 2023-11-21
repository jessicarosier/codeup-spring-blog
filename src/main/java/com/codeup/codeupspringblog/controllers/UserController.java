package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    // DEPENDENCY INJECTION
    private final UserRepository userDao;

    // INSTANTIATES A NEW POST REPOSITORY WHICH IS USED TO ACCESS THE DATABASE
    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/sign-up")
    public String getCreateUserForm(Model model) {
        model.addAttribute("user", new User());

        return "users/register";
    }

    @PostMapping("/sign-up")
    public String createUser(@ModelAttribute User user) {

        String hashedPsswd = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hashedPsswd);

        userDao.save(user);
        return "redirect:/posts";
    }
}
