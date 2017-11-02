package vn.its.rest.dao;

import java.util.List;

import vn.its.rest.model.Bill;

public interface BillDAO {
	
	public List<Bill> findAllBill();

	public Bill findBillById(long id);

	public void updateBill(Bill bill);

	public void deleteBill(long id);

	public void addBill(Bill bill);

}
