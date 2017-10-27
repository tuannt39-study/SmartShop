package vn.its.rest.dao;

import java.util.List;

import vn.its.rest.model.User;

public interface UserDAO {
	
	public List<User> getAllUsers();

	public void deleteUser(long id);

	public User updateUser(User user);

	public User findById(long id);
	
	public User getUserEmail(String email);
	
	public boolean isUserExist(User user);
	
	public void saveUser(User user);
	
}
