package vn.its.rest.service;

import java.util.List;

import vn.its.rest.model.Category;

public interface CategoryService {
	
	public List<Category> findAllCategory();
	
	public List<Category> findCategoryNews();
	
	public List<Category> findCategoryProducts();

	public Category findCategoryById(long id);

	public List<Category> findCategoryByName(String name);

	public void addCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(long id);

	public boolean isCategoryExist(Category category);
}
