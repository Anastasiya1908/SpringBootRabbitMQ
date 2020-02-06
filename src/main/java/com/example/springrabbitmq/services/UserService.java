package com.example.springrabbitmq.services;

import com.example.springrabbitmq.entity.UserRequest;
import com.example.springrabbitmq.repository.UserRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final UserRequestRepository userRequestRepository;

    public UserService(UserRequestRepository userRequestRepository) {
        this.userRequestRepository = userRequestRepository;
    }
    public List<UserRequest> findAll(){
        return userRequestRepository.findAll();
    }

    public void createUsers(UserRequest userRequest) {
        userRequestRepository.save(userRequest);
    }

    public UserRequest isEmailExists(String email) {
        return userRequestRepository.findByEMAIL(email);
    }

    public void updateExistingEmail(Integer id) {
        userRequestRepository.updateEMAIL(id);
    }

}
