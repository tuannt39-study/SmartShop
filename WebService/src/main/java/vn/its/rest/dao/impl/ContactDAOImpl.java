package vn.its.rest.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.ContactDAO;
import vn.its.rest.model.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO{
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> findAllContact() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	@Override
	public Contact findContactById(long id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Contact.class, id);
	}

	@Override
	public Contact findContactByName(String name) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Contact.class, name);
	}

	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(contact);
		return contact;
	}

	@Override
	public void deleteContact(long id) {
		// TODO Auto-generated method stub
		Contact contact = sessionFactory.getCurrentSession().load(Contact.class, id);
		if (contact != null) {
			this.sessionFactory.getCurrentSession().delete(contact);
		}
	}

	@Override
	public boolean isContactExist(Contact contact) {
		// TODO Auto-generated method stub
		return findContactByName(contact.getName()) != null;
	}

	@Override
	public void saveContact(Contact contact) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(contact);
	}

}
