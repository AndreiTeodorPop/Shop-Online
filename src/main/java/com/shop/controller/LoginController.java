package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Process data from client for authentication
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    public static final String LOGIN = "login";

    /**
     *
     * @return a String used for mapping a web page, a jsp file with the same name
     * @see <a href="http://localhost:9001/login/">Login</a>
     */
    @RequestMapping("/login")
    public String showLogin() {
        logger.info("This is the login page of the application!");
        return LOGIN;
    }
}
