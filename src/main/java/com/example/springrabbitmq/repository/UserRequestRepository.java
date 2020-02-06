package com.example.springrabbitmq.repository;

import com.example.springrabbitmq.entity.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Integer> {

    Optional<UserRequest> findByEmail(String email);

    @Modifying
    @Query(value = "update USER_REQUEST u set requests_count = requests_count+1 where u.id = ?1", nativeQuery = true)
    int updateEmail(Integer id);
}


