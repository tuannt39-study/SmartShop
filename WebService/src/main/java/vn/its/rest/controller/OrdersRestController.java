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

import vn.its.rest.model.Orders;
import vn.its.rest.service.OrdersService;

@RestController
@RequestMapping("/api/don-dat-hang")
public class OrdersRestController {

	public static final Logger logger = LoggerFactory.getLogger(OrdersRestController.class);

	@Autowired
	private OrdersService orderService;

//	http://localhost:8080/WebService/api/lien-he/all
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Orders>> findAllOrders() {
		List<Orders> findAllOrders = orderService.findAllOrders();
		if (findAllOrders.isEmpty()) {
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<List<Orders>> list = new ResponseEntity<List<Orders>>(findAllOrders, HttpStatus.OK);
			return list;
		}
	}

//	http://localhost:8080/WebService/api/don-dat-hang/3
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Orders> findOrders(@PathVariable("id") long id) {
		logger.info("Fetching Orders with id {}", id);
		Orders findOrders = orderService.findOrdersById(id);
		if (findOrders== null) {
			logger.error("Orders with id: " + id + " not found.");
			return new ResponseEntity<Orders>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<Orders> orders = new ResponseEntity<Orders>(findOrders, HttpStatus.OK);
			return orders;
		}
	}
	
//	http://localhost:8080/WebService/api/don-dat-hang/add
//	{
//	    "name": "Nguyễn Linh 5",
//	    "phone": "05736979",
//	    "email": "linhhg@gmail.com",
//	    "address": "Hà Nội",
//	    "note": "Chuyển nhanh đê",
//	    "amount": 936000,
//	    "userID": 0,
//	    "createdTime": 1509679766648,
//	    "status": "WAITING"
//	}
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Void> createOrders(@RequestBody Orders orders, UriComponentsBuilder ucbuilder) {
		logger.info("Add Orders : {}", orders);
		orderService.addOrders(orders);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucbuilder.path("{id}").buildAndExpand(orders.getId()).toUri());
		ResponseEntity<Void> createOrders = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		return createOrders;
	}

//	http://localhost:8080/WebService/api/don-dat-hang/update/5
//	{
//	    "name": "Nguyễn Linh 5",
//	    "phone": "05736979",
//	    "email": "linhhg@gmail.com",
//	    "address": "Hà Nội",
//	    "note": "Chuyển nhanh đê",
//	    "amount": 936000,
//	    "userID": 0,
//	    "createdTime": 1509679766648,
//	    "status": "WAITING"
//	}
	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<Orders> updateOrders(@PathVariable("id") long id, @RequestBody Orders orders) {
		logger.info("Update Orders with id {}", id);
		Orders currentOrders = orderService.findOrdersById(id);
		if (currentOrders  == null) {
			logger.error("Unable to update. Orders with id " + id + " not found.");
			return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
		} else {
			currentOrders.setName(orders.getName());
			currentOrders.setPhone(orders.getPhone());
			currentOrders.setEmail(orders.getEmail());
			currentOrders.setAddress(orders.getAddress());
			currentOrders.setNote(orders.getNote());
			currentOrders.setAmount(orders.getAmount());
			currentOrders.setStatus(orders.getStatus());
			orderService.updateOrders(currentOrders);
			ResponseEntity<Orders> updateOrders = new ResponseEntity<Orders>(currentOrders, HttpStatus.OK);
			return updateOrders;
		}
	}

//	http://localhost:8080/WebService/api/don-dat-hang/delete/4
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteOrders(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Orders with id {} ", id);
		Orders currentOrders = orderService.findOrdersById(id);
		if (currentOrders == null) {
			logger.error("Unable to delete. Orders with id {} not found.", id);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			orderService.deleteOrders(id);
			ResponseEntity<Void> deleteOrders = new ResponseEntity<Void>(HttpStatus.OK);
			return deleteOrders;
		}
	}
}
