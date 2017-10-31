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

import vn.its.rest.model.Category;
import vn.its.rest.service.CategoryService;

@RestController
@RequestMapping("/api/danh-muc")
public class CategoryRestController {

	public static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private CategoryService categoryService;

	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<Void> createCategory(@RequestBody Category category, UriComponentsBuilder ucbuilder) {
		logger.info("Add category : {}", category);

		if (categoryService.isCategoryExist(category)) {
			logger.error("Unable to add. A category with name " + category.getName() + " already exist.");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {

			categoryService.saveCategory(category);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucbuilder.path("{id}").buildAndExpand(category.getId()).toUri());
			ResponseEntity<Void> createCategory = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			return createCategory;
		}
	}

	// http://localhost:8080/WebService/api/danh-muc/all
	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<Category>> findAllCategory() {
		List<Category> findAllCategory = categoryService.findAllCategory();
		if (findAllCategory.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<List<Category>> list = new ResponseEntity<List<Category>>(findAllCategory, HttpStatus.OK);
			return list;
		}
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("id") long id, @RequestBody Category category) {
		logger.info("Fetching & Deleting category with id {} ", +id);
		Category currentCategory = categoryService.findCategoryById(id);
		if (currentCategory == null) {
			logger.error("Unable to delete. Category with id " + id + " not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			categoryService.deleteCategory(id);
			;
			ResponseEntity<Void> deleteCategory = new ResponseEntity<Void>(HttpStatus.OK);
			return deleteCategory;
		}
	}

	@CrossOrigin
	@PutMapping("/update/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
		logger.info("Update category with id {}", id);
		Category currentCategory = categoryService.findCategoryById(id);
		if (currentCategory == null) {
			logger.error("Unable to update. Category with id " + id + " not found.");
			return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
		} else {
			currentCategory.setName(category.getName());
			currentCategory.setNote(category.getNote());
			categoryService.updateCategory(currentCategory);
			ResponseEntity<Category> updateCategory = new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
			return updateCategory;
		}
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Category> findCategory(@PathVariable("id") long id) {
		logger.info("Fetching category with id {}", id);
		Category findCategory = categoryService.findCategoryById(id);
		if (findCategory == null) {
			logger.error("Bill with id: " + id + " not found.");
			return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<Category> category = new ResponseEntity<Category>(findCategory, HttpStatus.OK);
			return category;
		}
	}
}
