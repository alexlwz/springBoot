package com.fcloud.CICDServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcloud.CICDServer.dataBean.AccountInfo;

@RestController
@RequestMapping("/Bank")
public class BankController {
	@Autowired
	AccountInfo accountinfo;

	@RequestMapping("/info")
	public String obatainInfo() {
		return accountinfo.name + accountinfo.age.toString()
				+ accountinfo.money.toString();
	}

}
