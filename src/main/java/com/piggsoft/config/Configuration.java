/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/30                           Create
 */
package com.piggsoft.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/30
 * @since 1.0
 */
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public Interceptor[] mybatisInterceptors() {
        PageHelper pageHelper = new PageHelper();

        return new Interceptor[]{pageHelper};
    }

}
