package vn.its.rest.service;

import java.util.List;

import vn.its.rest.model.User;

public interface UserService {
	
	public List<User> getAllUsers();

	public void deleteUser(long id);

	public User updateUser(User user);

	public boolean isUserExist(User user);

	public void saveUser(User user);

	public User findById(long id);
}
