package com.fcloud.CICDServer.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fcloud.CICDServer.Mapper.UserMapper;
import com.fcloud.CICDServer.dataBean.AccountInfo;
import com.fcloud.CICDServer.dataBean.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 2018/3/20.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Account")
public class AccountController {

    @Autowired
    AccountInfo accountInfo;
    
	@Autowired
	private UserMapper usermapper;
    
    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSexAll() {
		/*
		 * @api {GET} /api/persons/sex Get all sexList
		 * 
		 * @apiName GetAllSexList
		 * 
		 * @apiGroup Info Manage
		 * 
		 * @apiVersion 1.0.0
		 * 
		 * @apiExample {httpie} Example usage:
		 * 
		 * http /api/persons/sex
		 * 
		 * @apiSuccess {String} label
		 * 
		 * @apiSuccess {String} value
		 */

		ArrayList<Map<String, String>> results = new ArrayList<>();
		for (Object value : usermapper.getAll()) {
			Map<String, String> account = new HashMap<>();
			account.put("info", value.toString());
			account.put("label", value.toString());
			account.put("value", value.toString());
			results.add(account);
		}
		ResponseEntity<ArrayList<Map<String, String>>> responseEntity = new ResponseEntity<>(
				results, HttpStatus.OK);
		//responseEntity.setHeader("Access-Control-Allow-Origin", "*");
		return responseEntity;
	}
    
}
