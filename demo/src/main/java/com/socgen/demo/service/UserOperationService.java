package com.socgen.demo.service;

import java.util.List;
import java.util.Map;
public interface UserOperationService {
	
	boolean createUser(Map<String,String> params);
	List<Map<String,String>> getUsers();

}
