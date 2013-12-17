package com.company.project.persist.system.impl;

import org.springframework.stereotype.Repository;

import com.company.project.model.system.User;
import com.company.project.persist.common.impl.GenericDaoImpl;
import com.company.project.persist.system.prototype.IUserDao;
/**
 * User实体Dao实现类
 * @author RanJi
 * @version jdk1.6
 * @since 2013-12-13
 */
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements IUserDao{
	
}
