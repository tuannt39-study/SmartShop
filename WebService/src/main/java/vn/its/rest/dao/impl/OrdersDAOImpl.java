package vn.its.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.OrdersDAO;
import vn.its.rest.model.Orders;

@Repository
public class OrdersDAOImpl implements OrdersDAO {
	
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public List<Orders> findAllOrders() {
		List<Orders> listOrders = new ArrayList<>();
		String sql = "from Orders";
		Session session = sessionFactory.getCurrentSession();
		listOrders = session.createQuery(sql, Orders.class).list();
		return listOrders;
	}

	@Override
	public Orders findOrdersById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Orders OrdersById = session.get(Orders.class, id);
		if (OrdersById == null) {
			return null;
		}
		return OrdersById;
	}

	@Override
	public void addOrders(Orders orders) {
		Session session = sessionFactory.getCurrentSession();
		session.save(orders);
	}

	@Override
	public void updateOrders(Orders orders) {
		Session session = sessionFactory.getCurrentSession();
		session.update(orders);
	}

	@Override
	public void deleteOrders(long id) {
		Session session = sessionFactory.getCurrentSession();
		Orders OrdersById = session.get(Orders.class, id);
		if (findOrdersById(id) != null) {
			session.delete(OrdersById);
		}
	}
}
