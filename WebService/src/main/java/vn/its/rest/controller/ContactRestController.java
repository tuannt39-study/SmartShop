package vn.its.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import vn.its.rest.model.Contact;
import vn.its.rest.service.ContactService;

@RestController
@RequestMapping("/api/lien-he")
public class ContactRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(ContactRestController.class);
	
	@Autowired
	private ContactService contactService;

//	http://localhost:8080/WebService/api/lien-he/all
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Contact>> findAllContact() {
		List<Contact> findAllContact = contactService.findAllContact();
		if (findAllContact.isEmpty()) {
			return new ResponseEntity<List<Contact>>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<List<Contact>> list = new ResponseEntity<List<Contact>>(findAllContact, HttpStatus.OK);
			return list;
		}
	}

//	http://localhost:8080/WebService/api/lien-he/3
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Contact> findContact(@PathVariable("id") long id) {
		logger.info("Fetching contact with id {}", id);
		Contact findContact = contactService.findContactById(id);
		if (findContact== null) {
			logger.error("Contact with id: " + id + " not found.");
			return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<Contact> contact = new ResponseEntity<Contact>(findContact, HttpStatus.OK);
			return contact;
		}
	}
	
//	http://localhost:8080/WebService/api/lien-he/add
//	{
//	    "name": "Công ty ITSOL 7",
//	    "email": "itsol@gmail.com",
//	    "phone": "09563856385",
//	    "fax": "09563856385",
//	    "address": "Tòa nhà 3A, 82 Duy Tân, Cầu Giấy, Hà Nội"
//	}
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Void> createContact(@RequestBody Contact contact, UriComponentsBuilder ucbuilder) {
		logger.info("Add contact : {}", contact);
		if (contactService.isContactExist(contact)) {
			logger.error("Unable to add. A contact with name " + contact.getName() + " already exist.");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			contactService.addContact(contact);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucbuilder.path("{id}").buildAndExpand(contact.getId()).toUri());
			ResponseEntity<Void> createContact = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			return createContact;
		}
	}

//	http://localhost:8080/WebService/api/lien-he/update/3
//	{
//	    "name": "Công ty ITSOL 3",
//	    "email": "itsol@gmail.com",
//	    "phone": "09563856385",
//	    "fax": "09563856385",
//	    "address": "Tòa nhà 3A, 82 Duy Tân, Cầu Giấy, Hà Nội"
//	}
	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable("id") long id, @RequestBody Contact contact) {
		logger.info("Update contact with id {}", id);
		Contact currentContact = contactService.findContactById(id);
		if (currentContact  == null) {
			logger.error("Unable to update. Contact with id " + id + " not found.");
			return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
		} else {
			currentContact.setName(contact.getName());
			currentContact.setEmail(contact.getEmail());
			currentContact.setPhone(contact.getPhone());
			currentContact.setFax(contact.getFax());
			currentContact.setAddress(contact.getAddress());
			contactService.updateContact(currentContact);
			ResponseEntity<Contact> updateContact = new ResponseEntity<Contact>(currentContact, HttpStatus.OK);
			return updateContact;
		}
	}

//	http://localhost:8080/WebService/api/lien-he/delete/5
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting contact with id {} ", id);
		Contact currentContact = contactService.findContactById(id);
		if (currentContact == null) {
			logger.error("Unable to delete. Contact with id {} not found.", id);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			contactService.deleteContact(id);
			ResponseEntity<Void> deleteContact = new ResponseEntity<Void>(HttpStatus.OK);
			return deleteContact;
		}
	}
}
