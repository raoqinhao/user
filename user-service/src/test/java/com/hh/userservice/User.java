package com.hh.userservice;

import com.hh.userservice.annotation.VerifyFieldStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable,Cloneable {

    @VerifyFieldStatus("1")
    private String userName;
    @VerifyFieldStatus
    private Integer userAge;

    public User(String userName, Integer userAge) {
        this.userName = userName;
        this.userAge = userAge;
    }

    public User(){
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return clone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }



}
