package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    // DEPENDENCY INJECTION
    private final UserRepository userDao;

    // INSTANTIATES A NEW POST REPOSITORY WHICH IS USED TO ACCESS THE DATABASE
    public UserController(UserRepository userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/create")
    public String getCreateUserForm() {

        return "users/create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user, Model model, @RequestParam(name="password") String password ,@RequestParam(name = "password_confirm") String passwordConfirm) {

        if (!password.equals(passwordConfirm)) {
            model.addAttribute("passwordError", "Passwords do not match");
            return "users/create";
        }

        user.setPassword(password);
        userDao.save(user);
        return "redirect:/login";
    }
}
