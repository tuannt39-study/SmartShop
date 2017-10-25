package vn.its.rest.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.UserDAO;
import vn.its.rest.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void deleteUser(Integer id) {
		User user = sessionFactory.getCurrentSession().load(User.class, id);
		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Override
	public User updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return user;
	}

	@Override
	public User getUser(int id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public User getUserEmail(String email) {
		return sessionFactory.getCurrentSession().get(User.class, email);
	}

	@Override
	public boolean isUserExist(User user) {
		return getUserEmail(user.getEmail())!=null;
	}

}
