package com.hh.userservice.strategy;

import com.hh.userservice.pojo.UserBean;
import org.springframework.stereotype.Component;

@Component
public class CreateBeanStrategy {

    public UserBean createUserBean() {
        return new UserBean();
    }

}
