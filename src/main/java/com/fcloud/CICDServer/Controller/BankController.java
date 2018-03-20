package com.fcloud.CICDServer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcloud.CICDServer.Mapper.UserMapper;
import com.fcloud.CICDServer.dataBean.AccountInfo;
import com.fcloud.CICDServer.dataBean.UserEntity;

@RestController
@RequestMapping("/Bank")
public class BankController {
	@Autowired
	AccountInfo accountinfo;
	@Autowired
	private UserMapper usermapper;

	@RequestMapping("/info")
	public String obatainInfo() {
		return accountinfo.name + accountinfo.age.toString()
				+ accountinfo.money.toString();
	}
	
	@RequestMapping("/userInfo")
	public String obtainInfo(){
		List<UserEntity> users = usermapper.getAll();
		UserEntity user= users.get(0);
		return user.getPassWord();
	}

}
