/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/25                           Create
 */
package com.piggsoft.controller;

import com.piggsoft.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/25
 * @since 1.0
 */
@Controller
@RequestMapping("/login")
public class UserController {


    @Autowired
    private HashedCredentialsMatcher matcher;

    @RequestMapping
    public void login() {
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
        // 登录后存放进shiro token
        UsernamePasswordToken token = new UsernamePasswordToken("aaaa", "bbbb");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
    }

    public void register(User user) {
        String username = user.getUsername();
        String passwordSalt = new SecureRandomNumberGenerator().nextBytes().toHex();
        String salt = username + passwordSalt;
        user.setPasswordSalt(passwordSalt);
        SimpleHash hash = new SimpleHash(matcher.getHashAlgorithmName(), user.getPassword(), salt, matcher.getHashIterations());
        user.setPassword(hash.toHex());
    }

    public static void main(String[] args) {
        String passwordSalt = new SecureRandomNumberGenerator().nextBytes().toHex();
        String salt = "aaaa" + passwordSalt;
        System.out.println(passwordSalt);
        SimpleHash hash = new SimpleHash("MD5", "bbbb", salt, 2);
        System.out.println(hash.toHex());
    }

}
