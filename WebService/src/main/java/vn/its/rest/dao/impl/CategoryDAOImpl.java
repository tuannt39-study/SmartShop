package vn.its.rest.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.CategoryDAO;
import vn.its.rest.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	@Override
	public Category findCategoryById(long id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@Override
	public Category findCategoryByName(String name) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findCategoryNews() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Category where note = 4").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findCategoryProducts() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Category where note != 4").list();
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(category);
		return category;
	}

	@Override
	public void deleteCategory(long id) {
		// TODO Auto-generated method stub
		Category category = sessionFactory.getCurrentSession().load(Category.class, id);
		if (category != null) {
			this.sessionFactory.getCurrentSession().delete(category);
		}
	}

	@Override
	public boolean isCategoryExist(Category category) {
		// TODO Auto-generated method stub
		return findCategoryByName(category.getName()) != null;
	}

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}

}
