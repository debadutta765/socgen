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

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.socgen.demo.service.UserOperationService;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class UserDaoImplTest {
	
	@Autowired
	UserOperationService userService;
	@Mock
	UserDaoImpl userDao;
	static List<Map<String,String>> userList=new ArrayList<>();
	
	@BeforeClass
	public static void init(){
		Date date = new GregorianCalendar(1988, Calendar.FEBRUARY, 11).getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		String dob = dateFormat.format(date);
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
	}

	@Test
	public void getUsersTest() {
		Mockito.when(userDao.getUsers()).thenReturn(userList);
		List<Map<String,String>> resultlist=userService.getUsers();
		Assert.assertEquals(resultlist.size(), userList.size());
	}

}
