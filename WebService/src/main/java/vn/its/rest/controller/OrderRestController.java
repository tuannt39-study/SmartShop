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

import vn.its.rest.model.Order;
import vn.its.rest.service.OrderService;

@RestController
@RequestMapping("/api/don-dat-hang")
public class OrderRestController {

	public static final Logger logger = LoggerFactory.getLogger(OrderRestController.class);

	@Autowired
	private OrderService orderService;
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Void> createOrder(@RequestBody Order order, UriComponentsBuilder ucbuilder){
		logger.info("Add order : {}", order);
		
			orderService.saveOrder(order);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucbuilder.path("{id}").buildAndExpand(order.getId()).toUri());
			ResponseEntity<Void> createOrder = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			return createOrder;
		
	}
	
	//http://localhost:8080/WebService/api/don-dat-hang/all
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Order>> findAllOrder(){
		List<Order> findAllOrder = orderService.findAllOrder();
		if(findAllOrder.isEmpty()) {
			return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<List<Order>> list = new ResponseEntity<List<Order>>(findAllOrder, HttpStatus.OK);
			return list;
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<Void> deleteBill(@PathVariable("id") long id, @RequestBody Order order){
		logger.info("Fetching & Deleting order with id {} ", + id);
		Order currentOrder = orderService.findOrderById(id);
		if (currentOrder == null) {
			logger.error("Unable to delete. Order with id " + id + " not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			orderService.deleteOrder(id);;
			ResponseEntity<Void> deleteOrder = new ResponseEntity<Void>(HttpStatus.OK);
			return deleteOrder;
		}
	}
	
	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestBody Order order){
		logger.info("Update order with id {}", id);
		Order currentOrder = orderService.findOrderById(id);
		if (currentOrder == null) {
			logger.error("Unable to update. Order with id " + id + " not found.");
			return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
		} else {
			
			currentOrder.setName(order.getName());
			currentOrder.setAddress(order.getAddress());
			currentOrder.setAmount(order.getAmount());
			currentOrder.setEmail(order.getEmail());
			currentOrder.setPayment(order.getPayment());
			currentOrder.setPaymentInfo(order.getPaymentInfo());
			currentOrder.setNote(order.getNote());
			currentOrder.setPhone(order.getPhone());
			currentOrder.setUserID(order.getUserID());
			orderService.updateOrder(currentOrder);
			ResponseEntity<Order> updateOrder = new ResponseEntity<Order>(currentOrder, HttpStatus.OK);
			return updateOrder;
		}
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Order> findBill(@PathVariable("id") long id){
		logger.info("Fetching order with id {}", id);
		Order findOrder = orderService.findOrderById(id);
		if(findOrder == null) {
			logger.error("Order with id: " + id + " not found.");
			return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<Order> order = new ResponseEntity<Order>(findOrder, HttpStatus.OK);
			return order;
		}
	}
}
