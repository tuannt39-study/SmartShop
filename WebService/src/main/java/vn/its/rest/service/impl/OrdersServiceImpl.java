package vn.its.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.its.rest.dao.OrdersDAO;
import vn.its.rest.model.Orders;
import vn.its.rest.service.OrdersService;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	private OrdersDAO ordersDAO;

	@Override
	public List<Orders> findAllOrders() {
		return ordersDAO.findAllOrders();
	}

	@Override
	public Orders findOrdersById(long id) {
		return ordersDAO.findOrdersById(id);
	}

	@Override
	public void addOrders(Orders orders) {
		ordersDAO.addOrders(orders);
	}

	@Override
	public void updateOrders(Orders orders) {
		ordersDAO.updateOrders(orders);
	}

	@Override
	public void deleteOrders(long id) {
		ordersDAO.deleteOrders(id);
	}
}
