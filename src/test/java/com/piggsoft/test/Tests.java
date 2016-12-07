/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/12/7                           Create
 */
package com.piggsoft.test;

import org.junit.Test;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/12/7
 * @since 1.0
 */
public class Tests {

    @Test
    public void test01() {
        Object o = ClassLoader.getSystemClassLoader().getResource("static/templates/index.html");
        System.out.println(o);
    }

}
