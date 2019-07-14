package com.socgen.demo.dao;

import java.util.List;
import java.util.Map;

public interface UserDao {
	
	Map<String,String> getUser(String id);
	boolean createUser(Map<String,String> params);
	List<Map<String,String>> getUsers();

}
