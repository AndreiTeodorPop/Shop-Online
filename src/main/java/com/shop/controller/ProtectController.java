package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Allow admin to make changes in app interface
 */
@Controller
public class ProtectController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    public static final String PROTECT = "protect";

    /**
     *
     * @return a String used for mapping a web page, a jsp file with the same name
     * @see <a href="http://localhost:9001/protected/">Protected page</a>
     */
    @RequestMapping("/protect")
    public String showProtected() {
        logger.info("This is the protect page of the application!");
        return PROTECT;
    }
}
