package com.socgen.demo.serviceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socgen.demo.dao.UserDao;
import com.socgen.demo.exception.ApplicationException;
import com.socgen.demo.service.UserOperationService;
@Service
public class UserOperationServiceImpl implements UserOperationService {
	@Autowired
	UserDao userDao;

	@Override
	public boolean createUser(Map<String, String> params) {
		// TODO Auto-generated method stub
		return userDao.createUser(params);
	
	
	}

	@Override
	public List<Map<String, String>> getUsers() {
		// TODO Auto-generated method stub
		List<Map<String,String>> resultList = userDao.getUsers();
		Collections.sort(resultList, new Comparator<Map<String, String>>(){ 
	        public int compare(Map<String, String> one, Map<String, String> two) { 
	            return one.get("firstName").compareTo(two.get("firstName"));
	        } 
	});
		return resultList;
		

}
}