package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.Integer.parseInt;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    public String getRollDice() {
        return "dice";
    }

    @PostMapping("/roll-dice")
    public String getRollDiceGuess(@RequestParam(name = "guess")String guess, Model model) {
        System.out.println(guess);
        model.addAttribute("guess", parseInt(guess));
        model.addAttribute("random", (int) Math.floor(Math.random() * 6) + 1);
        return "dice";
    }

}
