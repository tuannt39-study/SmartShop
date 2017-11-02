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

@RestController
@RequestMapping("/api/hoa-don")
public class BillRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(BillRestController.class);
	
	@Autowired
	private BillService billService;

//	http://localhost:8080/WebService/api/hoa-don/all
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Bill>> getAllBill() {
		List<Bill> getAllBill = billService.findAllBill();
		if (getAllBill.isEmpty()) {
			return new ResponseEntity<List<Bill>>(HttpStatus.NO_CONTENT);
		}
		ResponseEntity<List<Bill>> listBill = new ResponseEntity<List<Bill>>(getAllBill, HttpStatus.OK);
		return listBill;
	}

//	http://localhost:8080/WebService/api/hoa-don/3
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Bill> getBillById(@PathVariable("id") long id) {
		logger.info("Fetching Bill with id {}", id);
		Bill getBillById = billService.findBillById(id);
		if (getBillById == null) {
			logger.error("Bill with id {} not found.", id);
			return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
		}
		ResponseEntity<Bill> Bill = new ResponseEntity<Bill>(getBillById, HttpStatus.OK);
		return Bill;
	}
	
//	http://localhost:8080/WebService/api/hoa-don/add
//	{
//	    "orderId": 2,
//	    "productId": 2,
//	    "quantity": 3,
//	    "amount": 1104000,
//	    "note": "NO",
//	    "status": "WAITING"
//	}
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Void> addBill(@RequestBody Bill bill, UriComponentsBuilder ucbuilder) {
		logger.info("Add Bill : {}", bill);
		billService.addBill(bill);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucbuilder.path("{id}").buildAndExpand(bill.getId()).toUri());
		ResponseEntity<Void> addBill = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		return addBill;
	}
	
//	http://localhost:8080/WebService/api/hoa-don/update/6
//	{
//	    "orderId": 2,
//	    "productId": 2,
//	    "quantity": 3,
//	    "amount": 1104000,
//	    "note": "NO",
//	    "status": "WAITING"
//	}
	@CrossOrigin
	@PutMapping("update/{id}")
	public ResponseEntity<Bill> updateBill(@PathVariable("id") long id, @RequestBody Bill bill) {
		logger.info("Updating Bill with id {}", id);
		Bill currentBill = billService.findBillById(id);
		if (currentBill == null) {
			logger.error("Unable to update. Bill with id " + id + " not found.");
			return new ResponseEntity<Bill>(HttpStatus.NOT_FOUND);
		}
		currentBill.setOrderId(bill.getOrderId());
		currentBill.setProductId(bill.getProductId());
		currentBill.setQuantity(bill.getQuantity());
		currentBill.setAmount(bill.getAmount());
		currentBill.setNote(bill.getNote());
		currentBill.setStatus(bill.getStatus());
		billService.updateBill(currentBill);
		ResponseEntity<Bill> updateBill = new ResponseEntity<Bill>(currentBill, HttpStatus.OK);
		return updateBill;
	}
	
//	http://localhost:8080/WebService/api/hoa-don/delete/2
	@CrossOrigin
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteBill(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Bill with id {}", id);
		Bill currentBill = billService.findBillById(id);
		if (currentBill == null) {
			logger.error("Unable to update. Bill with id {} not found.", id);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		billService.deleteBill(id);
		ResponseEntity<Void> deleteBill = new ResponseEntity<Void>(HttpStatus.OK);
		return deleteBill;
	}
}
