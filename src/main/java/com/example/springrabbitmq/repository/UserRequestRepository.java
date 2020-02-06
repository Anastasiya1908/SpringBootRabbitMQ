package com.example.springrabbitmq.repository;

import com.example.springrabbitmq.entity.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Integer> {

    UserRequest findByEMAIL(String email);

    @Modifying
    @Query(value="update USER_REQUEST u set REQUESTS_COUNT = REQUESTS_COUNT+1 where u.id = ?1", nativeQuery=true)
    int updateEMAIL(Integer id);
}


