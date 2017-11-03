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
import vn.its.rest.service.OrderService;

@RestController
@RequestMapping("/api/don-dat-hang")
public class OrderRestController {

	public static final Logger logger = LoggerFactory.getLogger(OrderRestController.class);

	@Autowired
	private OrderService orderService;
	
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Orders>> findAllOrder(){
		List<Orders> findAllOrders = orderService.findAllOrder();
		if (findAllOrders.isEmpty()) {
			return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<List<Orders>> list = new ResponseEntity<List<Orders>>(findAllOrders, HttpStatus.OK);
			return list;
		}
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Orders> findBill(@PathVariable("id") long id){
		logger.info("Fetching order with id {}", id);
		Orders findOrder = orderService.findOrderById(id);
		if(findOrder == null) {
			logger.error("Order with id: " + id + " not found.");
			return new ResponseEntity<Orders>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<Orders> order = new ResponseEntity<Orders>(findOrder, HttpStatus.OK);
			return order;
		}
	}
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Void> createOrder(@RequestBody Orders order, UriComponentsBuilder ucbuilder){
		logger.info("Add order : {}", order);
			orderService.addOrder(order);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucbuilder.path("{id}").buildAndExpand(order.getId()).toUri());
			ResponseEntity<Void> createOrder = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			return createOrder;
	}
	
	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<Orders> updateOrder(@PathVariable("id") long id, @RequestBody Orders order){
		logger.info("Update order with id {}", id);
		Orders currentOrder = orderService.findOrderById(id);
		if (currentOrder == null) {
			logger.error("Unable to update. Order with id " + id + " not found.");
			return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
		} else {
			currentOrder.setName(order.getName());
			currentOrder.setPhone(order.getPhone());
			currentOrder.setEmail(order.getEmail());
			currentOrder.setAddress(order.getAddress());
			currentOrder.setNote(order.getNote());
			currentOrder.setAmount(order.getAmount());
			currentOrder.setStatus(order.getStatus());
			orderService.updateOrder(currentOrder);
			ResponseEntity<Orders> updateOrder = new ResponseEntity<Orders>(currentOrder, HttpStatus.OK);
			return updateOrder;
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<Void> deleteBill(@PathVariable("id") long id, @RequestBody Orders order){
		logger.info("Fetching & Deleting order with id {} ", + id);
		Orders currentOrder = orderService.findOrderById(id);
		if (currentOrder == null) {
			logger.error("Unable to delete. Order with id " + id + " not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			orderService.deleteOrder(id);;
			ResponseEntity<Void> deleteOrder = new ResponseEntity<Void>(HttpStatus.OK);
			return deleteOrder;
		}
	}
}
