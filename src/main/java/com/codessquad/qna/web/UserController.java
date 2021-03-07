package com.codessquad.qna.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users")
    public String users() {
        logger.debug("List users");
        return "users/list";
    }

    @PostMapping("/users")
    public String create(User user, Model model) {
        logger.debug("User info: " + user);
        return "redirect:/users";
    }
}
