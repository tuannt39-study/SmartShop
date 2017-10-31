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
		// TODO Auto-generated method stub
		return categoryDAO.findAllCategory();
	}

	@Override
	public Category findCategoryById(long id) {
		// TODO Auto-generated method stub
		return categoryDAO.findCategoryById(id);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryDAO.updateCategory(category);
	}

	@Override
	public void deleteCategory(long id) {
		// TODO Auto-generated method stub
		categoryDAO.deleteCategory(id);
	}

	@Override
	public boolean isCategoryExist(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		categoryDAO.saveCategory(category);
	}

	@Override
	public List<Category> findCategoryNews() {
		// TODO Auto-generated method stub
		return categoryDAO.findCategoryNews();
	}

	@Override
	public List<Category> findCategoryProducts() {
		// TODO Auto-generated method stub
		return categoryDAO.findCategoryProducts();
	}

}
