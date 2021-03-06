/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/30                           Create
 */
package com.piggsoft.service;

import com.piggsoft.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/30
 * @since 1.0
 */
public interface IUserService {

    long register(User user);

    User queryUserByUsername(String username);

    Set<String> findRolesByUsername(String username);
}
