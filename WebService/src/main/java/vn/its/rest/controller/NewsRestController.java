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

import vn.its.rest.model.News;
import vn.its.rest.service.NewsService;

@RestController
@RequestMapping("/api/news")
public class NewsRestController {

	public static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private NewsService newsService;

//	http://localhost:8083/WebService/api/news/all
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<News>> getAllNews() {

		List<News> getAllNews = newsService.findAllNews();

		if (getAllNews.isEmpty()) {

			return new ResponseEntity<List<News>>(HttpStatus.NO_CONTENT);
		}

		ResponseEntity<List<News>> listNews = new ResponseEntity<List<News>>(getAllNews, HttpStatus.OK);

		return listNews;
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<News> getNewsById(@PathVariable("id") long id) {

		logger.info("Fetching User with id {}", id);

		News getNews = newsService.searchNewsById(id);

		if (getNews == null) {

			logger.error("User with id {} not found.", id);

			return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
		}

		ResponseEntity<News> news = new ResponseEntity<News>(getNews, HttpStatus.OK);

		return news;
	}

//	http://localhost:8080/WebService/api/news/add
//	{
//	    "title": "a2",
//	    "brief": "b2",
//	    "content": "c2",
//	    "categoryID": 1,
//	    "userID": 23,
//	    "createdTime": "30-10-2017 05:46:28"
//	}
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Void> addNews(@RequestBody News news, UriComponentsBuilder ucbuilder) {

		logger.info("Add User : {}", news);

		if (newsService.isNewsExist(news)) {

			logger.error("Unable to Add. A User with email {} already exist", news.getTitle());

			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		newsService.addNews(news);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucbuilder.path("{id}").buildAndExpand(news.getId()).toUri());
		ResponseEntity<Void> addNews = new ResponseEntity<Void>(headers, HttpStatus.CREATED);

		return addNews;
	}
	
//	http://localhost:8083/WebService/api/news/update/2
//	{
//	    "title": "a23",
//	    "brief": "b2",
//	    "content": "c2",
//	    "categoryID": 1,
//	    "userID": 23,
//	    "createdTime": "30-10-2017 05:46:28"
//	}
	@CrossOrigin
	@PutMapping("update/{id}")
	public ResponseEntity<News> updateNews(@PathVariable("id") long id,@RequestBody News news) {

		logger.info("Updating User with id {}", id);

		News currentNews = newsService.searchNewsById(id);

		if (currentNews == null) {

			logger.error("Unable to update. User with id " + id + " not found.");

			return new ResponseEntity<News>(HttpStatus.NOT_FOUND);
		}

		currentNews.setTitle(news.getTitle());
		currentNews.setBrief(news.getBrief());
		
		newsService.updateNews(currentNews);

		ResponseEntity<News> NewsIsUpdated = new ResponseEntity<News>(currentNews, HttpStatus.OK);

		return NewsIsUpdated;

	}

	@CrossOrigin
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteNews(@PathVariable("id") long id) {

		logger.info("Fetching & Deleting User with id {}", id);

		News currentNews = newsService.searchNewsById(id);

		if (currentNews == null) {
			logger.error("Unable to update. User with id {} not found.", id);

			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		newsService.deleteNews(id);

		ResponseEntity<Void> NewsIsDeleted = new ResponseEntity<Void>(HttpStatus.OK);
		return NewsIsDeleted;
	}

}
