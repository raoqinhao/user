package com.hh.userservice.config;

import com.hh.userservice.pojo.Permission;
import com.hh.userservice.pojo.Role;
import com.hh.userservice.pojo.UserBean;
import com.hh.userservice.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

public class UserBeanRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        //获取已经登录的用户，查看该用户是否有权限
//        //UserBean user = (UserBean) SecurityUtils.getSubject().getPrincipal();
//        UserBean userBean = (UserBean) principalCollection.getPrimaryPrincipal();
//        if (userBean == null) {
//            return null;
//        }
//        SimpleAuthorizationInfo simple = new SimpleAuthorizationInfo();
//        Set<Role> roles = userBean.getRoles();
//        if (roles != null) {
//            Set<String> roleName = roles.stream().collect(Collectors.mapping(role -> role.getName(), Collectors.toSet()));
//            simple.addRoles(roleName);
//            Set<Set<Permission>> role = roles.stream().map(Role::getPermissions).collect(Collectors.toSet());
//            role.forEach(roleSet -> {
//                Set<String> permissions = roleSet.stream().collect(Collectors.mapping(Permission::getPermissionString, Collectors.toSet()));
//                simple.addStringPermissions(permissions);
//            });
//        }
//        return simple;
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        //获取用户的信息
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
//        String username = usernamePasswordToken.getUsername();
//        String password = "";
//        UserBean userBean = null;
//        if (!"".equals(username) && username != null) {
//            userBean = userService.findUserBeanByUserBeanName(username);
//            if (userBean != null) {
//                password = userBean.getPassword();
//            }
//        }
//        return new SimpleAuthenticationInfo(userBean, password, getName());
        return null;
    }
}
