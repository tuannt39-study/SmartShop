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

import vn.its.rest.model.FeedBack;
import vn.its.rest.service.FeedBackService;

@RestController
@RequestMapping("/api/phan-hoi")
public class FeedBackRestController {
	
	public static final Logger logger = LoggerFactory.getLogger(FeedBackRestController.class);
	
	@Autowired
	private FeedBackService feedBackService;

//	http://localhost:8080/WebService/api/phan-hoi/all
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<FeedBack>> findAllFeedBack() {
		List<FeedBack> findAllFeedBack = feedBackService.findAllFeedBack();
		if (findAllFeedBack.isEmpty()) {
			return new ResponseEntity<List<FeedBack>>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<List<FeedBack>> list = new ResponseEntity<List<FeedBack>>(findAllFeedBack, HttpStatus.OK);
			return list;
		}
	}

//	http://localhost:8080/WebService/api/phan-hoi/2
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<FeedBack> findFeedBack(@PathVariable("id") long id) {
		logger.info("Fetching FeedBack with id {}", id);
		FeedBack findFeedBack = feedBackService.findFeedBackById(id);
		if (findFeedBack== null) {
			logger.error("FeedBack with id: " + id + " not found.");
			return new ResponseEntity<FeedBack>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<FeedBack> FeedBack = new ResponseEntity<FeedBack>(findFeedBack, HttpStatus.OK);
			return FeedBack;
		}
	}
	
//	http://localhost:8080/WebService/api/phan-hoi/add
//	{
//	    "name": "Dương 3",
//	    "email": "duongml@gmail.com",
//	    "phone": "09563856385",
//	    "note": "Đưa hàng nhanh, chất lượng ok, cảm thấy tốt.",
//	    "createdTime": "30-10-2017 11:07:21"
//	}
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Void> createFeedBack(@RequestBody FeedBack feedBack, UriComponentsBuilder ucbuilder) {
		logger.info("Add FeedBack : {}", feedBack);
		feedBackService.addFeedBack(feedBack);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucbuilder.path("{id}").buildAndExpand(feedBack.getId()).toUri());
		ResponseEntity<Void> createFeedBack = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		return createFeedBack;
	}

//	http://localhost:8080/WebService/api/phan-hoi/update/2
//	{
//	    "name": "Dương 3",
//	    "email": "duongml@gmail.com",
//	    "phone": "09563856385",
//	    "note": "Đưa hàng nhanh, chất lượng ok, cảm thấy tốt.",
//	    "createdTime": "30-10-2017 11:07:21"
//	}
	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<FeedBack> updateFeedBack(@PathVariable("id") long id, @RequestBody FeedBack feedBack) {
		logger.info("Update FeedBack with id {}", id);
		FeedBack currentFeedBack = feedBackService.findFeedBackById(id);
		if (currentFeedBack  == null) {
			logger.error("Unable to update. FeedBack with id " + id + " not found.");
			return new ResponseEntity<FeedBack>(HttpStatus.NOT_FOUND);
		} else {
			currentFeedBack.setName(feedBack.getName());
			currentFeedBack.setEmail(feedBack.getEmail());
			currentFeedBack.setPhone(feedBack.getPhone());
			currentFeedBack.setNote(feedBack.getNote());
			feedBackService.updateFeedBack(currentFeedBack);
			ResponseEntity<FeedBack> updateFeedBack = new ResponseEntity<FeedBack>(currentFeedBack, HttpStatus.OK);
			return updateFeedBack;
		}
	}

//	http://localhost:8080/WebService/api/phan-hoi/delete/2
	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteFeedBack(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting FeedBack with id {} ", id);
		FeedBack currentFeedBack = feedBackService.findFeedBackById(id);
		if (currentFeedBack == null) {
			logger.error("Unable to delete. FeedBack with id {} not found.", id);
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			feedBackService.deleteFeedBack(id);
			ResponseEntity<Void> deleteFeedBack = new ResponseEntity<Void>(HttpStatus.OK);
			return deleteFeedBack;
		}
	}

}
