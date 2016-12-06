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
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Set;

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
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", before = false, resultType = long.class, keyProperty = "id", keyColumn = "id")
    int saveUser(User user);

    @SelectProvider(type = UserSelectProvider.class, method = "findRoleByUsername")
    List<String> findRoleByUsername(String username);


    class UserSelectProvider {
        public String findRoleByUsername() {
            return new SQL() {{
                SELECT("tr.role_name");
                FROM("t_user_role as tur");
                LEFT_OUTER_JOIN("t_user as tu on tur.user_id = tu.id");
                LEFT_OUTER_JOIN("t_role as tr on tur.role_id = tr.id");
                WHERE("tu.username = #{username}");
            }}.toString();
        }
    }
}
