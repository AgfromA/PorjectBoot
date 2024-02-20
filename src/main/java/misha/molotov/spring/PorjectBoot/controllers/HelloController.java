package misha.molotov.spring.PorjectBoot.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping
    public String printWelcome() {
        return "index";
    }
}
