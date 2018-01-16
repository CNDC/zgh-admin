package com.uintell.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @date 2017/12/15 15:36
 */
@RestController
@RequestMapping("/")
public class HelloController {
    private static final Logger logger = Logger.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String demo() {
        logger.info("hello ------------------");
        return "dfhsjkdhfkjsdhfjkhsd";
    }
}
