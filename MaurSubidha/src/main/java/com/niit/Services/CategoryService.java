package com.niit.Services;

import java.util.List;

import com.niit.model.Category;
import com.niit.model.Product;

public interface CategoryService {
	void saveOrUpdateCategory(Category category);

	List<Category> getAllCategories();
	
	public Category getByName(String name);

	void deleteCategory(int cid);

	Category getCategoryBycid(int cid);
	

}
