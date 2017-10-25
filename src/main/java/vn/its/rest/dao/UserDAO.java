package vn.its.rest.dao;

import java.util.List;

import vn.its.rest.model.User;

public interface UserDAO {
	
	public void addUser(User user);

	public List<User> getAllUsers();

	public void deleteUser(Integer id);

	public User updateUser(User user);

	public User getUser(int id);
	
	public User getUserEmail(String email);
	
	boolean isUserExist(User user);
	
}
