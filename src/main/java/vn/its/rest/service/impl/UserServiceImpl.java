package vn.its.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.its.rest.dao.UserDAO;
import vn.its.rest.model.User;
import vn.its.rest.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public boolean addUser(User user) {
		if (userDAO.isUserExist(user)) {
			return false;
		} else {
			userDAO.addUser(user);
			return true;
		}
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public void deleteUser(Integer id) {
		userDAO.deleteUser(id);
	}

	@Override
	public User updateUser(User user) {
		return userDAO.updateUser(user);
	}

	@Override
	public User getUser(int id) {
		return userDAO.getUser(id);
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
