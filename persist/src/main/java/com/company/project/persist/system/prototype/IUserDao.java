package com.company.project.persist.system.prototype;

import java.util.List;

import com.company.project.model.system.User;


/**
 * 系统用户Dao接口
 * @author 纪冉
 */
public interface IUserDao {
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public User getUser(int id);
	
	public void save(User user);
	public User findByName(String userName);
	public User findById(int id);
	public List<User> findAll();
	public void update(User user);
	public void delete(int id);
}
