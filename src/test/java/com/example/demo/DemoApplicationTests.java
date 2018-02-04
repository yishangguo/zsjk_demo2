package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}


//	@Autowired
//	private UserMapper userMapper;

	@Test
	public void test(){
//		userMapper.insert("test", "123456", "13333333333");
//		User u = userMapper.findUserByPhone("13333333333");
//		Assert.assertEquals("test", u.getName());
	}

}
