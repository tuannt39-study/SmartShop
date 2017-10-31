package vn.its.rest.dao.impl;

import java.util.List;

import org.hibernate.Session;
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
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User order by ID ASC").list();
	}

	@Override
	public void deleteUser(long id) {
		User user = sessionFactory.getCurrentSession().load(User.class, id);
		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Override
	public void updateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		user.setUsername(user.getUsername());
		user.setFullname(user.getFullname());
		user.setEmail(user.getEmail());
		user.setAddress(user.getAddress());
		user.setPassword(user.getPassword());
		user.setAvartar(user.getAvartar());
		user.setCreatedTime(user.getCreatedTime());
		user.setPhone(user.getPhone());
		user.setStatus(user.getStatus());
		session.flush();
	}

	@Override
	public User findById(long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public User findUserByEmail(String email) {
		return sessionFactory.getCurrentSession().get(User.class, email);
	}

	@Override
	public boolean isUserExist(User user) {
		return findUserByEmail(user.getEmail()) != null;
	}

}
