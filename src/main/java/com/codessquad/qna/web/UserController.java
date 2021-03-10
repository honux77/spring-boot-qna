package com.codessquad.qna.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }

    @GetMapping("/users/{id}")
    public String profile(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        model.addAttribute("user", user);
        return "user/profile";
    }

    @GetMapping("/users/{id}/update")
    public String updateForm(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        logger.debug("GET user update-from: {}", user);
        model.addAttribute("user", user);
        return "user/update-form";
    }

    @PostMapping("/users")
    public String create(User user) {
        logger.debug("Create user: " + user);
        userRepository.save(user);
        return "redirect:/users/" + user.getId();
    }

    @PutMapping("/users/{id}")
    public String update(User newUser, Model model) {
        if(!newUser.validate()) throw new IllegalArgumentException();
        User user = userRepository.findById(newUser.getId()).orElseThrow(IllegalArgumentException::new);
        logger.debug("update User: {} <- {}", user, newUser);
        user.update(newUser);
        userRepository.save(user);
        model.addAttribute("user", user);
        return "redirect:/users/" + user.getId();
    }
}
