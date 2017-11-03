package vn.its.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.ContactDAO;
import vn.its.rest.model.Contact;

@Repository
public class ContactDAOImpl implements ContactDAO{
	
	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public List<Contact> findAllContact() {
		List<Contact> listContact = new ArrayList<>();
		String sql = "from Contact";
		Session session = sessionFactory.getCurrentSession();
		listContact = session.createQuery(sql, Contact.class).list();
		return listContact;
	}

	@Override
	public Contact findContactById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Contact contactById = session.get(Contact.class, id);
		if (contactById == null) {
			return null;
		}
		return contactById;
	}

	@Override
	public List<Contact> findContactByName(String name) {
		List<Contact> contactByName = new ArrayList<>();
		for (Contact listContactByName : findAllContact()) {
			String nameTemp = listContactByName.getName();
			if (nameTemp.contains(name)) {
				contactByName.add(listContactByName);
				return contactByName;
			}
		}
		return null;
	}

	@Override
	public void addContact(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		session.save(contact);
	}

	@Override
	public void updateContact(Contact contact) {
		Session session = sessionFactory.getCurrentSession();
		session.update(contact);
	}

	@Override
	public void deleteContact(long id) {
		Session session = sessionFactory.getCurrentSession();
		Contact contactById = session.get(Contact.class, id);
		if (findContactById(id) != null) {
			session.delete(contactById);
		}
	}

	@Override
	public boolean isContactExist(Contact contact) {
		if (findContactByName(contact.getName()) != null) {
			return true;
		} else {
			return false;
		}
	}

}
