package vn.its.rest.dao;

import java.util.List;

import vn.its.rest.model.Order;

public interface OrderDAO {
	
	public List<Order> findAllOrder();

	public Order findOrderById(long id);

	public Order updateOrder(Order order);

	public void deleteOrder(long id);

	public void saveOrder(Order order);
}
