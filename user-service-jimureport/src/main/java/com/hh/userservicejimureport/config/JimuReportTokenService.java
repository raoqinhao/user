package com.hh.userservicejimureport.config;

import com.alibaba.fastjson.JSONObject;
import com.hh.userservicejimureport.utils.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.modules.jmreport.api.JmReportTokenServiceI;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName JimuReportTokenService
 * @Deacription TODO
 * @Author 饶钦浩
 * @Date 2021/4/19 9:50
 * @Version 1.0
 **/
@Component
public class JimuReportTokenService implements JmReportTokenServiceI {

    @Override
    public String getToken(HttpServletRequest request) {
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getHeader("X-Access-Token");
        }
        return token;
    }

    @Override
    public String getUsername(String token) {
        return TokenUtils.parse(token);
    }

    @Override
    public Boolean verifyToken(String token) {
        boolean verify = TokenUtils.verify(token);
        return verify;
    }
}
