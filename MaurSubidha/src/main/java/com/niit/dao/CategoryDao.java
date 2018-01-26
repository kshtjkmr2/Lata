package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDao {

	List<Category> getAllCategories();

	public Category getByName(String name);

	void saveOrUpdateCategory(Category category);

	void deletecategory(int cid);

	Category getcategoryBycid(int cid);
	
}
