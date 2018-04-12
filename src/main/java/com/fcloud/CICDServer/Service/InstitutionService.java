package com.fcloud.CICDServer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fcloud.CICDServer.Mapper.InstitutionMapper;
import com.fcloud.CICDServer.Mapper.UserMapper;
import com.fcloud.CICDServer.dataBean.AccountInfo;
import com.fcloud.CICDServer.dataBean.InstitutionInfo;
import com.fcloud.CICDServer.dataBean.UserEntity;

@Service
public class InstitutionService {
	@Autowired
	AccountInfo accountinfo;
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private InstitutionMapper institutionMapper;
	
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void obtainInstitution(InstitutionInfo institutionInfo)
	{
		institutionMapper.insert(institutionInfo);
		InstitutionInfo test = institutionMapper.getOne(institutionInfo.getInstitutionId());
		System.out.println(test.getInstitutionName());
		if(test.getInstitutionId().equals("xx"))
		{
			int j = 10/0;
			System.out.println(j);
		}
	}
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public String testInstitution(String institutionId, String userName)
	{
		InstitutionInfo institutionInfo = institutionMapper.getOne(institutionId);
		UserEntity userEntity = usermapper.getOne(userName);		
		return institutionInfo.getInstitutionName()+userEntity.getPassWord();
		
	}
}
