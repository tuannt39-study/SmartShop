package vn.its.rest.dao;

import java.util.List;

import vn.its.rest.model.Product;

public interface ProductDAO {

	public List<Product> findAllProduct();

	public Product findProductById(long id);

	public Product findProductByName(String name);

	public Product updateProduct(Product product);

	public void deleteProduct(long id);

	public boolean isProductExist(Product product);

	public void saveProduct(Product product);
}
