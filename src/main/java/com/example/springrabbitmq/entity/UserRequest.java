package com.example.springrabbitmq.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_REQUEST")
public class UserRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String email;

    @Column
    private Integer requestsCount;

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

    public Integer getRequestsCount() {
        return requestsCount;
    }

    public void setRequestsCount(Integer requestsCount) {
        this.requestsCount = requestsCount;
    }

    public UserRequest() {
    }

    public UserRequest(String email, Integer requestsCount) {
        this.email = email;
        this.requestsCount = requestsCount;
    }
}
