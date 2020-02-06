package com.example.springrabbitmq.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_REQUEST")
public class UserRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "email")
    private String EMAIL;

    @Column
    private Integer REQUESTS_COUNT;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public Integer getREQUESTS_COUNT() {
        return REQUESTS_COUNT;
    }

    public void setREQUESTS_COUNT(Integer REQUESTS_COUNT) {
        this.REQUESTS_COUNT = REQUESTS_COUNT;
    }

   public UserRequest(){

    }

    public UserRequest(String EMAIL, Integer REQUESTS_COUNT){
        this.EMAIL = EMAIL;
        this.REQUESTS_COUNT = REQUESTS_COUNT;
    }
}
