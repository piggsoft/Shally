/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/30                           Create
 */
package com.piggsoft.service.impl;

import com.piggsoft.mapper.UserMapper;
import com.piggsoft.model.User;
import com.piggsoft.service.IUserService;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/30
 * @since 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private HashedCredentialsMatcher matcher;

    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        String username = user.getUsername();
        String passwordSalt = new SecureRandomNumberGenerator().nextBytes().toHex();
        String salt = username + passwordSalt;
        user.setPasswordSalt(passwordSalt);
        SimpleHash hash = new SimpleHash(matcher.getHashAlgorithmName(), user.getPassword(), salt, matcher.getHashIterations());
        user.setPassword(hash.toHex());
        userMapper.saveUser(user);
        return user.getId();
    }

    @Override
    public User queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }
}
