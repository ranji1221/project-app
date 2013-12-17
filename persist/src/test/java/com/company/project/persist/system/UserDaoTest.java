package com.company.project.persist.system;


import javax.annotation.Resource;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.project.persist.system.prototype.IUserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/spring-persist.xml")
public class UserDaoTest {

	@Resource
	private IUserDao userDao;

	@Before
	public void init() {
		PropertyConfigurator.configure(IUserDao.class.getClassLoader()
				.getResourceAsStream("config/log4j.properties"));
	}

	@Test
	public void testAddUser() {
//		for(int i=1;i<=100;i++){
//			User u = new User("lisi"+i, "123", (byte) 1, "test user.");
//			userDao.save(u, User.class);
//		}
	}
	@Test
	public void testUpdateUser(){
//		User u = userDao.findByID(93, User.class);
//		u.setUname("lisi-update");
//		userDao.update(u, User.class);
	}
	
	@Test
	public void testDeleteUser(){
		//userDao.deleteByID(90, User.class);
		//userDao.deleteAll(User.class);
	}
	
	@Test
	public void testFindAllUsers(){
//		List<User> users = userDao.findAll(User.class);
//		for(User u : users){
//			System.out.println(u.getUname());
//		}
	}
	
	@Test
	public void testFindPaginated1(){
//		SystemContext.setOffset(0);
//		SystemContext.setPageSize(5);
//		PagerModel<User> pm = userDao.findPaginated(User.class);
//		System.out.println(pm.getTotal());
//		for(User u : pm.getData()){
//			System.out.println(u.getUname());
//		}
	}
}



