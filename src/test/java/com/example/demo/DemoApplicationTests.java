package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.Utils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Test
	public void contextLoads() {
		String password = Utils.encodeMd5("123");
		String password1 = Utils.encodeMd5("zsjk");
		String password2 = Utils.encodeMd5("wawawa");
		String password3 = Utils.encodeMd5("number");
		String password4 = Utils.encodeMd5("gys456");
		userMapper.insert("test",password,"13333333333",1);
		userMapper.insert("test1",password1,"12222222222",1);
		userMapper.insert("test2",password2,"11111111111",0);
		userMapper.insert("test3",password3,"10000000000",0);
		userMapper.insert("test4",password4,"17777777777",1);
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
