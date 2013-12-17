package com.company.project.service.system;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.project.model.system.User;
import com.company.project.service.system.prototype.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring-persist.xml","classpath:config/spring-service.xml"})
public class UserServiceTest {
	
	@Resource
	private IUserService userService;
	
	@Test
	public void testGetUser(){
		
		User u = userService.findByID(94, User.class);
		
		if(u != null)
			assertEquals("lisi1", u.getUname());
	}
	
	@Test
	public void testAddUser(){
		//User u = new User("wangba", "123", (byte)1, "test user.");
		//userService.addUser(u);
	}
}
