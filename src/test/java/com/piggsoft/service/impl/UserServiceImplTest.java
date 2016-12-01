package com.piggsoft.service.impl;

import com.piggsoft.ShallyCoreApplicationTests;
import com.piggsoft.model.User;
import com.piggsoft.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/30
 * @since 1.0
 */
public class UserServiceImplTest extends ShallyCoreApplicationTests {

    @Autowired
    private IUserService userService;

    @Test
    public void register() throws Exception {
        User user = new User();
        user.setUsername("aaaa");
        user.setPassword("bbbb");
        int id = userService.register(user);
        System.out.println(user);
    }

}