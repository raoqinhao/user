package com.hh.userserviceapi.service;

import com.hh.userserviceapi.pojo.UserBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("USER-SERVICE-PROVIDE")
@Component
public interface UserService {

    @RequestMapping(value = "/findUserInfo/{id}", method = RequestMethod.GET)
    UserBean findUserInfo(@PathVariable String id);

}
