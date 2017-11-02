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

	@Override
	public List<Bill> findAllBill() {
		return billDAO.findAllBill();
	}

	@Override
	public Bill findBillById(long id) {
		return billDAO.findBillById(id);
	}

	@Override
	public void updateBill(Bill bill) {
		billDAO.updateBill(bill);
	}

	@Override
	public void deleteBill(long id) {
		billDAO.deleteBill(id);
	}

	@Override
	public void addBill(Bill bill) {
		billDAO.addBill(bill);
	}

}
