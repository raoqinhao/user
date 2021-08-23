package com.hh.userserviceapi.fallback;

import com.hh.userserviceapi.pojo.UserBean;
import com.hh.userserviceapi.service.UserService;
import org.springframework.stereotype.Component;

/***
* 功能描述:<br>
* @参数
* @描述: 回调，降级
* @创建人: 饶钦浩
* @时间: ${DATE} ${TIME}
* @return
* @throws
*/
@Component
public class UserFallBack implements UserService {
    @Override
    public UserBean findUserInfo(String id) {
        return new UserBean("服","务","降","级","了");
    }
}
