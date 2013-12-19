package com.company.project.persist.system;


import javax.annotation.Resource;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ranji.system.SystemContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.project.model.pager.PagerModel;
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
		for(int i=1;i<=6;i++){
			User u = new User("zhangsan"+i, "123", -1, "test user.");
			userDao.save(u, User.class);
		}
	}
	@Test
	public void testUpdateUser(){
		User u = userDao.findByID(196, User.class);
		u.setUname("lisi-no-update");
		u.setEnabled(-1);
		u.setDescription("");
		userDao.update(u, User.class);
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
		//-- 1.设置分页的偏移量和页大小
		SystemContext.setOffset(0);
		SystemContext.setPageSize(5);
		
		//-- 2. 模拟从页面中获取参数(一般是JSON对象)
		//-- 利用该JSON对象的参数构造值对象User(无ID)，示例如下：
		User paramsVO = new User();
		paramsVO.setUname("a");
		paramsVO.setEnabled(-1);
		
		//-- 3. 后台执行分页查找
		PagerModel<User> pm = userDao.findPaginated(paramsVO,User.class);
		
		//-- 4. 返回总条目数和相对应的数据
		System.out.println(pm.getTotal());
		for(User u : pm.getData()){
			System.out.println(u.getUname());
		}
	}
}



