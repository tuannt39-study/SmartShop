package vn.its.rest.service;

import java.util.List;

import vn.its.rest.model.Bill;

public interface BillService {
	
	public List<Bill> findAllBill();

	public Bill findBillById(long id);

	public void updateBill(Bill bill);

	public void deleteBill(long id);

	public void addBill(Bill bill);
}
