package vn.its.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.its.rest.dao.CategoryDAO;
import vn.its.rest.model.Category;
import vn.its.rest.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public List<Category> findAllCategory() {
		return categoryDAO.findAllCategory();
	}

	@Override
	public List<Category> findCategoryNews() {
		return categoryDAO.findCategoryNews();
	}

	@Override
	public List<Category> findCategoryProducts() {
		return categoryDAO.findCategoryProducts();
	}

	@Override
	public Category findCategoryById(long id) {
		return categoryDAO.findCategoryById(id);
	}

	@Override
	public void addCategory(Category category) {
		categoryDAO.addCategory(category);
	}

	@Override
	public List<Category> findCategoryByName(String name) {
		return categoryDAO.findCategoryByName(name);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDAO.updateCategory(category);
	}

	@Override
	public void deleteCategory(long id) {
		categoryDAO.deleteCategory(id);
	}

	@Override
	public boolean isCategoryExist(Category category) {
		if (categoryDAO.isCategoryExist(category) == true) {
			return true;
		}
		return false;
	}

}
