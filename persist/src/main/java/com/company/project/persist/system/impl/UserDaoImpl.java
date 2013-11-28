package com.company.project.persist.system.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.company.project.model.system.User;
import com.company.project.persist.system.prototype.IUserDao;

/**
 * @author 纪冉
 */
@Repository
public class UserDaoImpl implements IUserDao {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Override
	public boolean addUser(User user) {
		SqlSession s = sqlSessionFactory.openSession();
		int userId = s.insert("addUser",user);
		s.close();
		return userId != 0;
	}

	@Override
	public boolean updateUser(User user) {
		SqlSession s = sqlSessionFactory.openSession();
		int userId = s.update("updateUser",user);
		return userId != 0;
	}

	@Override
	public User getUser(int id) {
		SqlSession s = sqlSessionFactory.openSession();
		User user = s.selectOne("getUser", id);
		return user;
	}

	@Override
	public void save(User user) {
		
	}

	@Override
	public User findByName(String userName) {
		SqlSession s = sqlSessionFactory.openSession();
		User user = s.selectOne("findByName", userName);
		return user;
	}

	@Override
	public User findById(int id) {
		return null;
	}

	@Override
	public List<User> findAll() {
		SqlSession s = sqlSessionFactory.openSession();
		List<User> users = s.selectList("findAll");
		return users;
	}

	@Override
	public void update(User user) {
		
	}

	@Override
	public void delete(int id) {
		SqlSession s = sqlSessionFactory.openSession();
		s.delete("deleteUser", id);
		s.close();
	}

}
