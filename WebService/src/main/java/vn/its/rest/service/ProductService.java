package vn.its.rest.service;

import java.util.List;

import vn.its.rest.model.Product;

public interface ProductService {
	
	public List<Product> findAllProduct();

	public Product findProductById(long id);

	public Product updateProduct(Product product);

	public void deleteProduct(long id);

	public boolean isProductExist(Product product);

	public void saveProduct(Product product);
}
