package vn.its.rest.dao;

import java.util.List;

import vn.its.rest.model.Category;

public interface CategoryDAO {
	
	public List<Category> findAllCategory();

	public Category findCategoryById(long id);

	public Category findCategoryByName(String name);

	public Category updateCategory(Category category);

	public void deleteCategory(long id);

	public boolean isCategoryExist(Category category);

	public void saveCategory(Category category);
}
