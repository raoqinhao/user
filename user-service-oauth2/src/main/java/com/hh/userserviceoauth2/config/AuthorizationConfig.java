package com.hh.userserviceoauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.stereotype.Component;

@Component
@EnableAuthorizationServer
public class AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()
                .checkTokenAccess("permitAll()");
    }

     // http://localhost:8110/oauth/token?code=5o1f7J&grant_type=authorization_code&redirect_url=http://www.baidu.com/callback&scope=all&client_id=security_appid&client_secret=security_secret

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("security_appid")
                .secret(passwordEncoder.encode("security_secret"))
                .authorizedGrantTypes("authorization_code")
                .scopes("all")
                .resourceIds("security_resource")
                .redirectUris("https://www.baidu.com/callback");
    }
}
