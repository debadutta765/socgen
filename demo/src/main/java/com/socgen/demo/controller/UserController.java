package com.socgen.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.demo.service.UserOperationService;

@Repository
@RestController
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserOperationService userService;
	
	@RequestMapping(value="/createUser",method={ RequestMethod.POST }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createUser(@RequestBody Map<String,String> params){
		
		boolean flag = userService.createUser(params);
		ResponseEntity responseEntity= new ResponseEntity<>(flag,HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value="/getUser",method={ RequestMethod.GET }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getUsers(){
		List<Map<String,String>> userList = userService.getUsers();
		ResponseEntity responseEntity= new ResponseEntity<>(userList,HttpStatus.OK);
		return responseEntity;
	}
	
	
	

}
