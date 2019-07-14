package com.socgen.demo.daoImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.socgen.demo.dao.UserDao;
import com.socgen.demo.exception.NoRecordException;
@Repository
public class UserDaoImpl implements UserDao {
	
	List<Map<String,String>> resultList=new ArrayList<>();

	@Override
	public Map<String, String> getUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createUser(Map<String, String> params) {
		// TODO Auto-generated method stub
		resultList.add(params);
		return true;
	}

	@Override
	public List<Map<String, String>> getUsers() {
		// TODO Actual DB Call. Instead I am returning a List of user. 
		//I am storing the User DB column name and value in a map. We can do the same
		//using the JdbcNamedParameter, by getting the meta data of the table from the 
		//JdbcNamedParameetr
		Date date = new GregorianCalendar(1988, Calendar.FEBRUARY, 11).getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String dob = dateFormat.format(date);
		List<Map<String,String>> userList=new ArrayList<>();
		Map<String,String> user1=new HashMap();
		user1.put("id", "socgen001");
		user1.put("firstName", "Debadutta");
		user1.put("lastName", "Rath");
		user1.put("gender", "Male");
		user1.put("dob", dob);
		user1.put("department", "Computer Science");
		
		Map<String,String> user2=new HashMap();
		user2.put("id", "socgen002");
		user2.put("firstName", "Ajay");
		user2.put("lastName", "Rath");
		user2.put("gender", "Male");
		user2.put("dob", dob);
		user2.put("department", "Information Technolgy");
		
		Map<String,String> user3=new HashMap();
		user3.put("id", "socgen003");
		user3.put("firstName", "Aditi");
		user3.put("lastName", "Rath");
		user3.put("gender", "Female");
		user3.put("dob", dob);
		user3.put("department", "Hardware Infra");
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		if(userList == null)
			throw new NoRecordException("No User record found");
		return userList;
	}

}
