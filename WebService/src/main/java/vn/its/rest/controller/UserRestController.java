package vn.its.rest.controller;

import java.util.Date;
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

import vn.its.rest.model.User;
import vn.its.rest.service.UserService;

@RestController
@RequestMapping("/api/tai-khoan")
public class UserRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
	@Autowired
	private UserService userService;

//	http://localhost:8080/WebService/api/tai-khoan/all
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> getAllUsers = userService.getAllUsers();
		if (getAllUsers.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<List<User>> list = new ResponseEntity<List<User>>(getAllUsers, HttpStatus.OK);
			return list;
		}
	}

//	http://localhost:8080/WebService/api/tai-khoan/5
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") long id){
		logger.info("Fetching user with id {}", id);
		User getUser = userService.findById(id);
		if (getUser == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			ResponseEntity<User> user = new ResponseEntity<User>(getUser, HttpStatus.OK);
			return user;
		}
	}

//	http://localhost:8080/WebService/api/tai-khoan/add
//	{
//	    "email": "thinh@gmail.com",
//	    "username": "thinh 7",
//	    "fullname": "Nguyễn Thịnh",
//	    "phone": "0963349515",
//	    "address": "Hà Nội",
//	    "avartar": "/assets/layouts/layout/img/avartar.png",
//	    "createdTime": "03-11-2017 03:29:01",
//	    "status": "ACTIVE",
//	    "password": "1234"
//	}
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Void> addUser(@RequestBody User user, UriComponentsBuilder ucbuilder) {
		logger.info("Add User : {}", user);
		if (userService.isUserExist(user)) {
			logger.error("Unable to Add. A User with email {} already exist", user.getEmail());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			user.setAvartar("/assets/layouts/layout/img/avartar.png");
			user.setCreatedTime(new Date());
			userService.saveUser(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucbuilder.path("{id}").buildAndExpand(user.getId()).toUri());
			ResponseEntity<Void> addUser = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			return addUser;
		}
	}

//	http://localhost:8080/WebService/api/tai-khoan/update/7
//	{
//	    "email": "thinh@gmail.com",
//	    "username": "thinh 71",
//	    "fullname": "Nguyễn Thịnh",
//	    "phone": "0963349515",
//	    "address": "Hà Nội",
//	    "avartar": "/assets/layouts/layout/img/avartar.png",
//	    "createdTime": "03-11-2017 03:29:01",
//	    "status": "ACTIVE",
//	    "password": "1234"
//	}
	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		logger.info("Updating User with id {}", id);
		User currentUser = userService.findById(id);
		if (currentUser == null) {
			logger.error("Unable to update. User with id " + id + " not found.");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			currentUser.setEmail(user.getEmail());
			currentUser.setUsername(user.getUsername());
			currentUser.setFullname(user.getFullname());
			currentUser.setPhone(user.getPhone());
			currentUser.setAddress(user.getAddress());
			currentUser.setAvartar("/assets/layouts/layout/img/avartar.png");
			currentUser.setCreatedTime(new Date());
			currentUser.setStatus(user.getStatus());
			currentUser.setPassword(user.getPassword());
			userService.updateUser(currentUser);
			ResponseEntity<User> updateUser = new ResponseEntity<User>(currentUser, HttpStatus.OK);
			return updateUser;
		}
	}

//	http://localhost:8080/WebService/api/tai-khoan/delete/6
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") long id){
		logger.info("Fetching & Deleting User with id {}", id);
		User currentUser = userService.findById(id);
		if (currentUser == null) {
			logger.error("Unable to delete. User with id {} not found.", id);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.deleteUser(id);
			ResponseEntity<Void> deleteUser = new ResponseEntity<Void>(HttpStatus.OK);
			return deleteUser;
		}
	}

}
