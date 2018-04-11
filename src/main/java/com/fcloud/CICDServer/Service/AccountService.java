package com.fcloud.CICDServer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcloud.CICDServer.Mapper.UserMapper;
import com.fcloud.CICDServer.dataBean.AccountInfo;

@Service
public class AccountService {
	@Autowired
	AccountInfo accountinfo;
	@Autowired
	private UserMapper usermapper;
	
	public void insertDatabase()
	{
		
	}
}
