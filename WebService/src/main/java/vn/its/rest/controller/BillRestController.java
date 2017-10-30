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

import vn.its.rest.model.Bill;
import vn.its.rest.service.BillService;

@CrossOrigin(origins = "http://localhost:8083", maxAge = 3600)
@RestController
@RequestMapping("/api/hoa-don")
public class BillRestController {
	public static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private BillService billService;
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Void> createBill(@RequestBody Bill bill, UriComponentsBuilder ucbuilder){
		logger.info("Add bill : {}", bill);
		
			billService.saveBill(bill);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucbuilder.path("{id}").buildAndExpand(bill.getId()).toUri());
			ResponseEntity<Void> createBill = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			return createBill;
	}
	
	//http://localhost:8080/WebService/api/hoa-don/all
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Bill>> findAllBill(){
		List<Bill> findAllBill = billService.findAllBill();
		if(findAllBill.isEmpty()) {
			return new ResponseEntity<List<Bill>>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<List<Bill>> list = new ResponseEntity<List<Bill>>(findAllBill, HttpStatus.OK);
			return list;
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<Void> deleteBill(@PathVariable("id") long id, @RequestBody Bill bill){
		logger.info("Fetching & Deleting bill with id {} ", + id);
		Bill currentBill = billService.findBillById(id);
		if (currentBill == null) {
			logger.error("Unable to delete. Bill with id " + id + " not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			billService.deleteBill(id);;
			ResponseEntity<Void> deleteBill = new ResponseEntity<Void>(HttpStatus.OK);
			return deleteBill;
		}
	}
	
	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<Bill> updateBill(@PathVariable("id") long id, @RequestBody Bill bill){
		logger.info("Update product with id {}", id);
		Bill currentBill = billService.findBillById(id);
		if (currentBill == null) {
			logger.error("Unable to update. Bill with id " + id + " not found.");
			return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
		} else {
			billService.updateBill(currentBill);
			ResponseEntity<Bill> updateBill = new ResponseEntity<Bill>(currentBill, HttpStatus.OK);
			return updateBill;
		}
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Bill> findBill(@PathVariable("id") long id){
		logger.info("Fetching bill with id {}", id);
		Bill findBill = billService.findBillById(id);
		if(findBill == null) {
			logger.error("Bill with id: " + id + " not found.");
			return new ResponseEntity<Bill>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<Bill> bill = new ResponseEntity<Bill>(findBill, HttpStatus.OK);
			return bill;
		}
	}
}
