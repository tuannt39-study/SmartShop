package vn.its.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.its.rest.dao.ProductDAO;
import vn.its.rest.model.Product;
import vn.its.rest.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return productDAO.findAllProduct();
	}

	@Override
	public Product findProductById(long id) {
		// TODO Auto-generated method stub
		return productDAO.findProductById(id);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.updateProduct(product);
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		productDAO.deleteProduct(id);
	}

	@Override
	public boolean isProductExist(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.saveProduct(product);
	}
	
}
