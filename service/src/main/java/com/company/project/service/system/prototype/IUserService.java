package com.company.project.service.system.prototype;

import java.util.List;
import com.company.project.model.system.User;

public interface IUserService {
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
