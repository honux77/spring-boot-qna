package com.codessquad.qna.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @GetMapping("/hello")
    public String welcome() {
        logger.info("GET /hello");
        return "welcome";
    }
}
