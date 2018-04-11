package com.fcloud.CICDServer.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcloud.CICDServer.Service.InstitutionService;
import com.fcloud.CICDServer.dataBean.AccountInfo;
import com.fcloud.CICDServer.dataBean.InstitutionInfo;


@RestController
@PropertySource("classpath:config/dao1.properties")
@RequestMapping("/Hello")
public class HelloController {

	@Autowired
	AccountInfo accountinfo;
	
	@Autowired
	InstitutionService institutionService;
	
	@Value("${test2.name}")
	private String name;

	@Value("${test2.money}")
	private String money;

	@Value("${test2.age}")
	private String age;
	
    @RequestMapping("/test")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/info")
    public String obatainInfo(){
    	return accountinfo.name+accountinfo.age.toString()+accountinfo.money.toString();
    }
    
    @RequestMapping("/info1")
    public String obatainInfo1(){
    	return name+age+money;
    }
    
    @RequestMapping("/infoInstitution")
    public void obtaininfoInstitution(){
    	InstitutionInfo institutionInfo = new InstitutionInfo();
    	institutionInfo.setInstitutionAbbr("aa");
    	institutionInfo.setInstitutionId("111");
    	institutionInfo.setInstitutionName("liwz");
    	institutionInfo.setInstitutionType("y");
    	institutionService.obtainInstitution(institutionInfo);
    }
}

