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
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public void deleteUser(long id) {
		userDAO.deleteUser(id);
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	
	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDAO.saveUser(user);
	}

}
