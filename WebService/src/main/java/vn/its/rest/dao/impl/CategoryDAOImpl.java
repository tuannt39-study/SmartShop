package vn.its.rest.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.its.rest.dao.CategoryDAO;
import vn.its.rest.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> findAllCategory() {
		List<Category> listCategory = new ArrayList<>();
		String sql = "from Category";
		Session session = sessionFactory.getCurrentSession();
		listCategory = session.createQuery(sql, Category.class).list();
		return listCategory;
	}

	@Override
	public List<Category> findCategoryNews() {
		List<Category> listCategoryNews = new ArrayList<>();
		String sql = "from Category where note = 4";
		Session session = sessionFactory.getCurrentSession();
		listCategoryNews = session.createQuery(sql, Category.class).list();
		return listCategoryNews;
	}

	@Override
	public List<Category> findCategoryProducts() {
		List<Category> listCategoryProducts = new ArrayList<>();
		String sql = "from Category where note != 4";
		Session session = sessionFactory.getCurrentSession();
		listCategoryProducts = session.createQuery(sql, Category.class).list();
		return listCategoryProducts;
	}

	@Override
	public Category findCategoryById(long id) {
		Session session = sessionFactory.getCurrentSession();
		Category categoryById = session.get(Category.class, id);
		if (categoryById == null) {
			return null;
		}
		return categoryById;
	}

	@Override
	public List<Category> findCategoryByName(String name) {
		List<Category> categoryByName = new ArrayList<>();
		for (Category listCategoryByName : findAllCategory()) {
			String nameTemp = listCategoryByName.getName();
			if (nameTemp.contains(name)) {
				categoryByName.add(listCategoryByName);
				return categoryByName;
			}
		}
		return null;
	}

	@Override
	public void addCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.save(category);
	}

	@Override
	public void updateCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		session.update(category);
	}

	@Override
	public void deleteCategory(long id) {
		Session session = sessionFactory.getCurrentSession();
		Category categoryById = session.get(Category.class, id);
		if (findCategoryById(id) != null) {
			session.delete(categoryById);
		}
	}

	@Override
	public boolean isCategoryExist(Category category) {
		if (findCategoryByName(category.getName()) != null) {
			return true;
		} else {
			return false;
		}
	}

}
