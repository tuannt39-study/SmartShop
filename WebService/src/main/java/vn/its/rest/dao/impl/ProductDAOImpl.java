package vn.its.rest.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.ProductDAO;
import vn.its.rest.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFatory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return sessionFatory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	public Product findProductById(long id) {
		// TODO Auto-generated method stub
		return sessionFatory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public Product findProductByName(String name) {
		// TODO Auto-generated method stub
		return sessionFatory.getCurrentSession().get(Product.class, name);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFatory.getCurrentSession().update(product);
		return product;
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		Product product = sessionFatory.getCurrentSession().load(Product.class, id);
		if (null != product) {
			this.sessionFatory.getCurrentSession().delete(product);
		}
	}

	@Override
	public boolean isProductExist(Product product) {
		// TODO Auto-generated method stub
		return findProductByName(product.getName()) != null;
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFatory.getCurrentSession().saveOrUpdate(product);
	}

}
