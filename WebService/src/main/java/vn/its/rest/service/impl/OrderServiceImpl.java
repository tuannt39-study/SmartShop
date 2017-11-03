package vn.its.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.its.rest.dao.OrderDAO;
import vn.its.rest.model.Orders;
import vn.its.rest.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public List<Orders> findAllOrder() {
		return orderDAO.findAllOrder();
	}

	@Override
	public Orders findOrderById(long id) {
		return orderDAO.findOrderById(id);
	}

	@Override
	public void addOrder(Orders order) {
		orderDAO.addOrder(order);
	}

	@Override
	public void updateOrder(Orders order) {
		orderDAO.updateOrder(order);
	}

	@Override
	public void deleteOrder(long id) {
		orderDAO.deleteOrder(id);
	}

}
