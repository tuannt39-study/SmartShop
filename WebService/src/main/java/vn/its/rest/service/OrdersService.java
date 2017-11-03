package vn.its.rest.service;

import java.util.List;

import vn.its.rest.model.Orders;

public interface OrdersService {
	
	public List<Orders> findAllOrders();

	public Orders findOrdersById(long id);

	public void addOrders(Orders Orders);

	public void updateOrders(Orders Orders);

	public void deleteOrders(long id);
}
