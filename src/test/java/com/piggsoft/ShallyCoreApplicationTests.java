package com.piggsoft;

import com.github.pagehelper.PageHelper;
import com.piggsoft.mapper.UserMapper;
import com.piggsoft.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShallyCoreApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUserMapper() {
		User user = userMapper.queryUserByUsername("aa");
		System.out.println(user);
	}

	@Test
	public void testPageHelper() {
		PageHelper.startPage(1, 10);
		User user = userMapper.queryUserByUsername("aa");
		System.out.println(user);
	}

}
