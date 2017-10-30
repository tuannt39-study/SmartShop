package vn.its.rest.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import vn.its.rest.model.Product;
import vn.its.rest.service.ProductService;

@RestController
@RequestMapping("/api/san-pham")
public class ProductRestController {
	public static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	private ProductService productService;
	
	@PostMapping("/add")
	public ResponseEntity<Void> createProduct(@RequestBody Product product, UriComponentsBuilder ucbuilder){
		logger.info("Add product : {}", product);
		if(productService.isProductExist(product)) {
			logger.error("Unable to add. A product with name " + product.getName() + " already exist.");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			productService.saveProduct(product);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucbuilder.path("{id}").buildAndExpand(product.getId()).toUri());
			ResponseEntity<Void> createProduct = new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			return createProduct;
		}
	}
	
	//http://localhost:8080/WebService/san-pham/all
	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProduct(){
		List<Product> findAllProduct = productService.findAllProduct();
		if(findAllProduct.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<List<Product>> list = new ResponseEntity<List<Product>>(findAllProduct, HttpStatus.OK);
			return list;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<Void> deleteProduct(@PathVariable("id") long id, @RequestBody Product product){
		logger.info("Fetching & Deleting product with id {} ", + id);
		Product currentProduct = productService.findProductById(id);
		if (currentProduct == null) {
			logger.error("Unable to delete. Product with id " + id + " not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			productService.deleteProduct(id);;
			ResponseEntity<Void> deleteProduct = new ResponseEntity<Void>(HttpStatus.OK);
			return deleteProduct;
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product){
		logger.info("Update product with id {}", id);
		Product currentProduct = productService.findProductById(id);
		if (currentProduct == null) {
			logger.error("Unable to update. Product with id " + id + " not found.");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		} else {
			productService.updateProduct(currentProduct);
			ResponseEntity<Product> updateProduct = new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
			return updateProduct;
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findProduct(@PathVariable("id") long id){
		logger.info("Fetching product with id {}", id);
		Product findProduct = productService.findProductById(id);
		if(findProduct == null) {
			logger.error("Product with id: " + id + " not found.");
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		} else {
			ResponseEntity<Product> product = new ResponseEntity<Product>(findProduct, HttpStatus.OK);
			return product;
		}
	}
}
