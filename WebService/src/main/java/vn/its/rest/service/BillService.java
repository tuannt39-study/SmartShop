package vn.its.rest.service;

import java.util.List;

import vn.its.rest.model.Bill;

public interface BillService {
	
	public List<Bill> findAllBill();

	public Bill findBillById(long id);

	public Bill updateBill(Bill bill);

	public void deleteBill(long id);

	public void saveBill(Bill bill);
}
