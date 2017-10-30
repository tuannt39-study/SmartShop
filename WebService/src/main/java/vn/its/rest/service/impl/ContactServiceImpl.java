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
		// TODO Auto-generated method stub
		return contactDAO.findAllContact();
	}

	@Override
	public Contact findContactById(long id) {
		// TODO Auto-generated method stub
		return contactDAO.findContactById(id);
	}

	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactDAO.updateContact(contact);
	}

	@Override
	public void deleteContact(long id) {
		// TODO Auto-generated method stub
		contactDAO.deleteContact(id);
	}

	@Override
	public boolean isContactExist(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveContact(Contact contact) {
		// TODO Auto-generated method stub
		contactDAO.saveContact(contact);
	}

}
