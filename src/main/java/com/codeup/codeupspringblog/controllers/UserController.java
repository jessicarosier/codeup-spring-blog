package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import jakarta.validation.Valid;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String displayRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "users/register";
    }


    //Grabs the user object from the form and makes sure it is valid using the annotations in the User model
    @PostMapping("/sign-up")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            model.addAttribute("user", user);
            return "users/register";
        }

        String hashedPsswd = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hashedPsswd);

        userDao.save(user);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String userLogin(Model model) {

        model.addAttribute("user", new User());

        return "users/login";
    }
}
