package com.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Return the Homepage of the application
 */
@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    public static final String HOMEPAGE = "homepage";

    /**
     *
     * @return a String used for mapping a web page, a jsp file with the same name
     * @see <a href="http://localhost:9001/shop/">Homepage</a>
     */
    @RequestMapping("/homepage")
    public String showIndex() {
        logger.info("This is the homepage of the application!");
        return HOMEPAGE;
    }
}
