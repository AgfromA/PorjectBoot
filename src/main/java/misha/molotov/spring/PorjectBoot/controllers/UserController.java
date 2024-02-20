package misha.molotov.spring.PorjectBoot.controllers;

import jakarta.validation.Valid;
import misha.molotov.spring.PorjectBoot.models.User;
import misha.molotov.spring.PorjectBoot.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/people")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("people", userService.getAllUsers());
        return "/index"; // Изменен путь к шаблону
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("users", new User());
        return "/new";
    }

    @PostMapping
    public String create(@ModelAttribute("users") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/new";

        userService.addUser(user);
        return "redirect:/people";

    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("users", userService.getUserById(id));
        return "/edit"; // Изменен путь к шаблону
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("users") @Valid User user,
                         BindingResult bindingResult, @RequestParam("id") Integer id) {
        if (bindingResult.hasErrors())
            return "/edit"; // Изменен путь к шаблону
        userService.updateUser(id, user);
        return "redirect:/people";

    }

    @GetMapping("/removeUser")
    public String delete(@RequestParam("id") Integer id) {
        userService.removeUser(id);
        return "redirect:/people";
    }
}