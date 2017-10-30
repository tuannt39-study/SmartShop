package vn.its.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.its.rest.dao.OrderDAO;
import vn.its.rest.model.Order;
import vn.its.rest.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public List<Order> findAllOrder() {
		// TODO Auto-generated method stub
		return orderDAO.findAllOrder();
	}

	@Override
	public Order findOrderById(long id) {
		// TODO Auto-generated method stub
		return orderDAO.findOrderById(id);
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		return orderDAO.updateOrder(order);
	}

	@Override
	public void deleteOrder(long id) {
		// TODO Auto-generated method stub
		orderDAO.deleteOrder(id);
	}

	@Override
	public void saveOrder(Order order) {
		// TODO Auto-generated method stub
		orderDAO.saveOrder(order);
	}

}
