package com.codessquad.qna.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private List<User> users = Collections.synchronizedList(new ArrayList<>());

    @GetMapping("/users")
    public String users(Model model) {
        logger.debug("List users, total users = " + users.size());
        model.addAttribute("users", users);
        return "users/list";
    }

    @PostMapping("/users")
    public String create(User user, Model model) {
        logger.debug("User info: " + user);

        if (!validate(user)) {
            logger.debug("User already exist: " + user);
            return "redirect:/users/form.html?error=FailToCreateUser";
        }

        addUser(user);
        return "redirect:/users";
    }

    private void addUser(User user) {
        users.add(user);
    }

    private boolean validate(User newUser) {
        for (User user : users) {
            if (user.equals(newUser)) {
                return false;
            }
        }
        return true;
    }
}
