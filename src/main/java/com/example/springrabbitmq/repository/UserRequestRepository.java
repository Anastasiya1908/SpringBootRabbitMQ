package com.example.springrabbitmq.repository;

import com.example.springrabbitmq.entity.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Integer> {

    Optional<UserRequest> findByEmail(String email);
}



