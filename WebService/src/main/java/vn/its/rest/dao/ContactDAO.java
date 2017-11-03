package vn.its.rest.dao;

import java.util.List;

import vn.its.rest.model.Contact;

public interface ContactDAO {
	
	public List<Contact> findAllContact();

	public Contact findContactById(long id);

	public List<Contact> findContactByName(String name);

	public void addContact(Contact contact);

	public void updateContact(Contact contact);

	public void deleteContact(long id);

	public boolean isContactExist(Contact contact);
}
