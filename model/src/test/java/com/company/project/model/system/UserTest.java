package com.company.project.model.system;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 * 测试实体User类
 * @author RanJi
 */
public class UserTest {
	
	@Test
	public void testUser(){
		User u = new User();
		u.setId(1);
		u.setUname("zhangsan");
		u.setPwd("123456");
		
		assertEquals(1, u.getId());
		assertEquals("zhangsan",u.getUname());
		assertEquals("123456",u.getPwd());
		
		assertNull("No Set User Description Info.",u.getDescription());
		assertEquals(0, u.getEnabled());
		assertTrue(0==u.getEnabled());
	}
}
