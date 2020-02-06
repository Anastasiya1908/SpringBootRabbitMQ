package com.example.springrabbitmq.listeners;


import com.example.springrabbitmq.entity.UserRequest;
import com.example.springrabbitmq.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class RabbitMqListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqListener.class);

    @Autowired
    public UserService userService;


    @RabbitListener(queues = "queue-1-1")
    @Transactional
    public void receiveEmail(String email) {
        Optional<UserRequest> userRequest = userService.getUserRequestByEmail(email);
        if (userRequest.isPresent()) {
            userService.updateExistingEmail(userRequest.get().getId());
        } else {
            userService.createUsers(new UserRequest(email, 1));
        }
        LOGGER.info("Email : " + email);
    }

}

