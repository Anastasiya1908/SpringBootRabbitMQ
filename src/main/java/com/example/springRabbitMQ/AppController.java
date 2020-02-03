package com.example.springRabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppController {
   
    static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @RequestMapping("/greeting")
    public void greeting(@RequestParam(value = "email") String email) {
        LOGGER.info("Received email: " + email);
    }
}
