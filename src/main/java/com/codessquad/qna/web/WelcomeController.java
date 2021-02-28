package com.codessquad.qna.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/hello")
    public String welcome(String name, int age, Model model) {
        logger.info("GET /hello");
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "welcome";
    }
}
