package com.example.springrabbitmq.services;

import com.example.springrabbitmq.entity.UserRequest;
import com.example.springrabbitmq.repository.UserRequestRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Value("${spring.rabbitmq.template.exchange}")
    private String exchangeName;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final UserRequestRepository userRequestRepository;

    public UserService(UserRequestRepository userRequestRepository) {
        this.userRequestRepository = userRequestRepository;
    }

    public void createUser(UserRequest userRequest) {
        userRequestRepository.save(userRequest);
    }

    public Optional<UserRequest> getUserRequestByEmail(String email) {
        return userRequestRepository.findByEmail(email);
    }


    public void sendEmailIfMore(String email) {
        rabbitTemplate.convertAndSend(exchangeName, "info", email);
    }

}
