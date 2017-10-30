package vn.its.rest.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.BillDAO;
import vn.its.rest.model.Bill;

@Repository
public class BillDAOImpl implements BillDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Bill> findAllBill() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Bill").list();
	}

	@Override
	public Bill findBillById(long id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Bill.class, id);
	}

	@Override
	public Bill updateBill(Bill bill) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(bill);
		return bill;
	}

	@Override
	public void deleteBill(long id) {
		// TODO Auto-generated method stub
		Bill bill = sessionFactory.getCurrentSession().load(Bill.class, id);
		if (bill != null) {
			this.sessionFactory.getCurrentSession().delete(bill);
		}
	}

	@Override
	public void saveBill(Bill bill) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(bill);
	}

}
