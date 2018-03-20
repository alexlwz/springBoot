package com.fcloud.CICDServer;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fcloud.CICDServer.dataBean.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CicdServerApplicationTests {

	@Autowired
	private com.fcloud.CICDServer.Mapper.UserMapper usermapper;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = usermapper.getAll();
		System.out.println("my first mybatis"+users.size());
		System.out.println(users.get(0).getUserName());
	}
	
	@Test
	public void testQueryOne()
	{
		
	}
	
}
