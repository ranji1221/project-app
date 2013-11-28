package com.company.project.persist.system;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import javax.annotation.Resource;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.company.project.model.system.User;
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

		User u = new User("zhangsan", "123", (byte) 1, "test user.");

		boolean isSuccess = false;
		try {
			isSuccess = userDao.addUser(u);
			fail("add error,because the user already exists.");
		} catch (Exception e) {
			assertFalse(isSuccess);
			return;
		}
		assertTrue(isSuccess);
	}
	
	@Test
	public void updateUser(){
		/*User u = userDao.getUser(29);
		System.out.println(u.getUname());
		System.out.println(u.getId());
		u.setUname("jiran");
		u.setEnabled((byte)0);
		System.out.println(u.getUname());
		
		userDao.updateUser(u);*/
	}
}
