package vn.its.rest.service;

import java.util.List;

import vn.its.rest.model.User;

public interface UserService {
	
	public boolean addUser(User user);

	public List<User> getAllUsers();

	public void deleteUser(Integer id);

	public User updateUser(User user);

	public User getUser(int id);
}
