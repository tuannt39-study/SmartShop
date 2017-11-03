package vn.its.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.its.rest.dao.ContactDAO;
import vn.its.rest.model.Contact;
import vn.its.rest.service.ContactService;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDAO contactDAO;

	@Override
	public List<Contact> findAllContact() {
		return contactDAO.findAllContact();
	}

	@Override
	public Contact findContactById(long id) {
		return contactDAO.findContactById(id);
	}

	@Override
	public List<Contact> findContactByName(String name) {
		return contactDAO.findContactByName(name);
	}

	@Override
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	@Override
	public void updateContact(Contact contact) {
		contactDAO.updateContact(contact);
	}

	@Override
	public void deleteContact(long id) {
		contactDAO.deleteContact(id);
	}

	@Override
	public boolean isContactExist(Contact contact) {
		if (contactDAO.isContactExist(contact) == true) {
			return true;
		}
		return false;
	}

}
