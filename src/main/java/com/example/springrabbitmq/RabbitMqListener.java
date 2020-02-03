package com.example.springrabbitmq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = "queue-1-1")
    public void receiveEmail(String email) {
        LOGGER.info("Email : " + email);
    }

}
