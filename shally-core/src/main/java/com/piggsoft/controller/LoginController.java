/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/25                           Create
 */
package com.piggsoft.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
public class LoginController {

    @RequestMapping
    public void login() {
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());
        // 登录后存放进shiro token
        UsernamePasswordToken token = new UsernamePasswordToken("aaaa", "bbbb");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
    }

}
