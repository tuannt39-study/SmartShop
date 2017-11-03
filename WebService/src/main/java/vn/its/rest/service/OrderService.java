package vn.its.rest.service;

import java.util.List;

import vn.its.rest.model.Orders;

public interface OrderService {
	
	public List<Orders> findAllOrder();

	public Orders findOrderById(long id);

	public void addOrder(Orders order);

	public void updateOrder(Orders order);

	public void deleteOrder(long id);
}
