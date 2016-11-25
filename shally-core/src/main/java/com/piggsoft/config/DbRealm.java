/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/25                           Create
 */
package com.piggsoft.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/25
 * @since 1.0
 */
public class DbRealm extends AuthorizingRealm {


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken at) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) at;
        // 通过表单接收的用户名
        String username = token.getUsername();
        if (username != null && !"".equals(username)) {
            return new SimpleAuthenticationInfo(username, token.getPassword(), getName());
        }

        return null;
    }
}
