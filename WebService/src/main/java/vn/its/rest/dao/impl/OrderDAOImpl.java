package vn.its.rest.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.OrderDAO;
import vn.its.rest.model.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> findAllOrder() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Order").list();
	}

	@Override
	public Order findOrderById(long id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Order.class, id);
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
	    sessionFactory.getCurrentSession().update(order);
		return order;
	}

	@Override
	public void deleteOrder(long id) {
		// TODO Auto-generated method stub
		Order order = sessionFactory.getCurrentSession().load(Order.class, id);
		if (order != null) {
			this.sessionFactory.getCurrentSession().delete(order);
		}
	}

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(order);
	}
	
}
