package com.codeup.codeupspringblog.controllers;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static java.lang.Integer.parseInt;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice")
    public String getRollDice() {
        return "dice";
    }

//    @GetMapping("/roll-dice/{n}")
//    public String getUserRoll(@PathVariable String n,Model model) {
//        model.addAttribute("n", n);
//        return "results";
//    }

    @PostMapping("/roll-dice")
    public String getRollDiceGuess(@RequestParam(name = "guess")String guess, Model model) {
        int wins = 0;
        int random = (int) Math.floor(Math.random() * 6) + 1;
       if(parseInt(guess) == random) {
           wins++;
           System.out.println(wins);
       }
        model.addAttribute("wins", wins);
        model.addAttribute("guess", parseInt(guess));
        model.addAttribute("random", random);
        return "dice";
    }

}
