/*
 *
 * Copyright (C) 1999-2016 IFLYTEK Inc.All Rights Reserved.
 * History：
 * Version   Author      Date                              Operation
 * 1.0       yaochen4    2016/11/30                           Create
 */
package com.piggsoft.mapper;

import com.piggsoft.model.User;
import org.apache.ibatis.annotations.*;

/**
 * @author yaochen4
 * @version 1.0
 * @create 2016/11/30
 * @since 1.0
 */
@Mapper
public interface UserMapper {

    @Results(id = "userResult", value = {
            @Result(column = "password_salt", property = "passwordSalt")
    })
    @Select("select * from t_user where username = #{username}")
    User queryUserByUsername(@Param("username") String username);

    @Insert("insert into t_user (id, username, password, password_salt) values(null, #{username}, #{password}, #{passwordSalt})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", before = false, resultType = Integer.class, keyProperty = "id", keyColumn = "id")
    int saveUser(User user);

}
