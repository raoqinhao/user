package com.hh.userservice.config;

import org.apache.shiro.session.mgt.ExecutorServiceSessionValidationScheduler;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//@Configuration
public class ShiroConfig {

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager")DefaultWebSecurityManager defaultWebSecurityManager) {
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
//
//        //设置过滤器链   常用的过滤器
//        /*
//            anon 无需认证
//            authc 必须认证
//            user 可以使用rememberMe的功能
//            perms 必须有权限才能访问
//            role 该资源必须得有角色权限才能访问
//         */
//        Map<String,String> authMap = new LinkedHashMap<>();
//        authMap.put("/static","anon");
//        authMap.put("/toLogin","anon");
//        authMap.put("/toVerifyCode","anon");
//        authMap.put("/toLogout","logout");
//        authMap.put("/**","authc");
//
//        shiroFilterFactoryBean.setLoginUrl("/user/toLogin");
//        shiroFilterFactoryBean.setSuccessUrl("/user/toIndex");
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(authMap);
//        return shiroFilterFactoryBean;
        return null;
    }

    @Bean("defaultWebSecurityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userBeanRealm") UserBeanRealm userBeanRealm) {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(userBeanRealm);
//        securityManager.setSessionManager(getSessionManager());
//        return securityManager;
        return null;
    }

    private SessionManager getSessionManager() {
//        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
//        sessionManager.setGlobalSessionTimeout(1000 * 60 * 30);
//        sessionManager.setSessionValidationScheduler(sessionValidationScheduler());
//        //定时检查session
//        sessionManager.setSessionValidationSchedulerEnabled(true);
//        sessionManager.setDeleteInvalidSessions(true);
//        return sessionManager;
        return null;
    }

    /**
     * 会话调度认证器
     *
     * @return
     */
    @Bean(name = "sessionValidationScheduler")
    public ExecutorServiceSessionValidationScheduler sessionValidationScheduler() {
//        ExecutorServiceSessionValidationScheduler executorServiceSessionValidationScheduler = new ExecutorServiceSessionValidationScheduler();
//        //设置调度时间间隔，单位毫秒，默认为1小时，现设为30分钟
//        executorServiceSessionValidationScheduler.setInterval(60 * 30 * 1000);
//        return executorServiceSessionValidationScheduler;
        return null;
    }

    @Bean("userBeanRealm")
    public UserBeanRealm getUserBeanRealm() {
        return new UserBeanRealm();
    }
}
