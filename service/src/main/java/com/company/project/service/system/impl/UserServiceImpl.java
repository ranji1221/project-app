package com.company.project.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.model.system.User;
import com.company.project.persist.system.prototype.IUserDao;
import com.company.project.service.system.prototype.IUserService;

/**
 * 用户服务接口实现
 * @author 纪冉
 */
@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public void save(User user) {
		
	}

	@Override
	public User findByName(String userName) {
		return userDao.findByName(userName);
	}

	@Override
	public User findById(int id) {
		return null;
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void update(User user) {
		
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}
}
