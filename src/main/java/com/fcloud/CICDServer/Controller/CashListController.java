package com.fcloud.CICDServer.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fcloud.CICDServer.Mapper.UserMapper;
import com.fcloud.CICDServer.dataBean.AccountInfo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Cashlist")
public class CashListController {
	
	@Autowired
	AccountInfo accountInfo;

	@Autowired
	private UserMapper usermapper;

	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getSexAll() {
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
		return responseEntity;
	}
	
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPersonsAll(
            //@RequestParam(value = "page", required = false) Integer pages,
            @RequestParam("sex") String sex
            //@RequestParam("email") String email
    ) {
      /*  Sort sort = new Sort(Direction.ASC, "id");
        Pageable pageable = new PageRequest(pages - 1, maxPerPage, sort);
        PaginationFormatting paginInstance = new PaginationFormatting();*/
    	System.out.println("just for test"+sex);
        return sex;
        //return paginInstance.filterQuery(sex, email, pageable);
    }

}
