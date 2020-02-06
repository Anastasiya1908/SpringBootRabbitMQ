package com.example.springrabbitmq.entity;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "USER_REQUEST")
public class UserRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String email;

    @Column
    private Integer requests_count;

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRequests_count() {
        return requests_count;
    }

    public void setRequests_count(Integer requests_count) {
        this.requests_count = requests_count;
    }

    public UserRequest() {
    }

    public UserRequest(String email, Integer requests_count) {
        this.email = email;
        this.requests_count = requests_count;
    }
}
