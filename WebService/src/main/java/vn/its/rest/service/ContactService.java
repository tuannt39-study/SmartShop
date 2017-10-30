package vn.its.rest.service;

import java.util.List;

import vn.its.rest.model.Contact;

public interface ContactService {
	
	public List<Contact> findAllContact();

	public Contact findContactById(long id);

	public Contact updateContact(Contact contact);

	public void deleteContact(long id);

	public boolean isContactExist(Contact contact);

	public void saveContact(Contact contact);
}
