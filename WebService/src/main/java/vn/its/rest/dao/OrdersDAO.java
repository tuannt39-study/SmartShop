package vn.its.rest.dao;

import java.util.List;

import vn.its.rest.model.Orders;

public interface OrdersDAO {
	
	public List<Orders> findAllOrders();

	public Orders findOrdersById(long id);

	public void addOrders(Orders Orders);

	public void updateOrders(Orders Orders);

	public void deleteOrders(long id);
}
