package com.example.springrabbitmq;

import com.example.springrabbitmq.entity.UserRequest;
import com.example.springrabbitmq.repository.UserRequestRepository;
import com.example.springrabbitmq.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.repository.query.Param;

@SpringBootApplication
public class SpringRabbitMqApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitMqApplication.class, args);
    }
}
