package vn.its.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.its.rest.dao.BillDAO;
import vn.its.rest.model.Bill;
import vn.its.rest.service.BillService;

@Service
@Transactional
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillDAO billDAO;
	
	public void setBillDAO(BillDAO billDAO) {
		this.billDAO = billDAO;
	}

	@Override
	public List<Bill> findAllBill() {
		// TODO Auto-generated method stub
		return billDAO.findAllBill();
	}

	@Override
	public Bill findBillById(long id) {
		// TODO Auto-generated method stub
		return billDAO.findBillById(id);
	}

	@Override
	public Bill updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return billDAO.updateBill(bill);
	}

	@Override
	public void deleteBill(long id) {
		// TODO Auto-generated method stub
		billDAO.deleteBill(id);
	}

	@Override
	public void saveBill(Bill bill) {
		// TODO Auto-generated method stub
		billDAO.saveBill(bill);
	}

}
