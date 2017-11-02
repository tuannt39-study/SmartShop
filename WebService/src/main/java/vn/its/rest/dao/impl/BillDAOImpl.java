package vn.its.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.BillDAO;
import vn.its.rest.model.Bill;

@Repository
public class BillDAOImpl implements BillDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Bill> findAllBill() {
		List<Bill> listBill = new ArrayList<>();
		String sql = "from Bill";
		Session session = sessionFactory.getCurrentSession();
		listBill = session.createQuery(sql, Bill.class).list();
		return listBill;
	}

	@Override
	public Bill findBillById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Bill bill = session.get(Bill.class, id);
		if (bill == null) {
			return null;
		}
		return bill;
	}

	@Override
	public void updateBill(Bill bill) {
		Session session = sessionFactory.getCurrentSession();
		session.update(bill);
	}

	@Override
	public void deleteBill(long id) {
		Session session = sessionFactory.getCurrentSession();
		Bill bill = session.get(Bill.class, id);
		if (findBillById(id) != null) {
			session.delete(bill);
		}
	}

	@Override
	public void addBill(Bill bill) {
		Session session = sessionFactory.getCurrentSession();
		session.save(bill);
	}

}
