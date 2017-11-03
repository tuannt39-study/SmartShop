package vn.its.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.OrderDAO;
import vn.its.rest.model.Orders;

@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Orders> findAllOrder() {
		List<Orders> listOrders = new ArrayList<>();
		String sql = "from Orders";
		Session session = sessionFactory.getCurrentSession();
		listOrders = session.createQuery(sql, Orders.class).list();
		return listOrders;
	}

	@Override
	public Orders findOrderById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Orders orderById = session.get(Orders.class, id);
		if (orderById == null) {
			return null;
		}
		return orderById;
	}

	@Override
	public void addOrder(Orders order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
	}

	@Override
	public void updateOrder(Orders order) {
		Session session = sessionFactory.getCurrentSession();
		session.update(order);
	}

	@Override
	public void deleteOrder(long id) {
		Session session = sessionFactory.getCurrentSession();
		Orders orderById = session.get(Orders.class, id);
		if (findOrderById(id) != null) {
			session.delete(orderById);
		}
	}

}
