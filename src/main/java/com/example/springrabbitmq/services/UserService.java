package com.example.springrabbitmq.services;

import com.example.springrabbitmq.entity.UserRequest;
import com.example.springrabbitmq.repository.UserRequestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRequestRepository userRequestRepository;

    public UserService(UserRequestRepository userRequestRepository) {
        this.userRequestRepository = userRequestRepository;
    }

    public Optional<UserRequest> getUserRequestByEmail(String email) {
        return userRequestRepository.findByEmail(email);
    }


}
