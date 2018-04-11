package com.fcloud.CICDServer;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fcloud.CICDServer.Mapper.InstitutionMapper;
import com.fcloud.CICDServer.dataBean.InstitutionInfo;
import com.fcloud.CICDServer.dataBean.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableTransactionManagement
public class CicdServerApplicationTests {

	@Autowired
	private com.fcloud.CICDServer.Mapper.UserMapper usermapper;
	
	@Autowired
	private InstitutionMapper institutionMapper; 
	
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
		String username="Guest";
		UserEntity userEntity = usermapper.getOne(username);
		System.out.println(userEntity.toString());
	}
	
	@Test
	public void testAddOne()
	{
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName("lwz");
		userEntity.setPassWord("lwz");
		userEntity.setUserRight("4");
		usermapper.insert(userEntity);
	}
	
	@Test
	public void testDelete(){
		UserEntity userEntity2 = usermapper.getOne("lwz");
		System.out.println(userEntity2.toString());
		usermapper.delete("lwz");
	}	
	
	@Test
	@Transactional//(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void testInstitution(){
		InstitutionInfo institutionInfo = new InstitutionInfo();
    	institutionInfo.setInstitutionAbbr("aa");
    	institutionInfo.setInstitutionId("100");
    	institutionInfo.setInstitutionName("liwz");
    	institutionInfo.setInstitutionType("y");
		institutionMapper.insert(institutionInfo);
		InstitutionInfo test = institutionMapper.getOne(institutionInfo.getInstitutionId());
		System.out.println(test.getInstitutionName());
		//int i=10/0;
	}
	
	

}
