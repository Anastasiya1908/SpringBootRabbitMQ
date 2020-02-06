package com.example.springrabbitmq.listeners;


import com.example.springrabbitmq.entity.UserRequest;
import com.example.springrabbitmq.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.springrabbitmq.repository.UserRequestRepository;

import javax.transaction.Transactional;

@Component
public class RabbitMqListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqListener.class);

    @Autowired
    public UserService userService;


    @RabbitListener(queues = "queue-1-1")
    @Transactional
    public void receiveEmail(String email) {
        UserRequest userRequest = userService.isEmailExists(email);
        if (userRequest != null) {
            userService.updateExistingEmail(userRequest.getID());
        } else {
            userService.createUsers(new UserRequest(email, 1));
        }
        LOGGER.info("Email : " + email);
    }

}
