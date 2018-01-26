package com.niit.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Services.CategoryService;
import com.niit.dao.CategoryDao;
import com.niit.model.Category;
@Service
public class CategoryServiceImpl implements CategoryService {
@Autowired
private CategoryDao categoryDao;
	public List<Category> getAllCategories() {
		
		return categoryDao.getAllCategories();
	}
	public Category getByName(String name) {
		return categoryDao.getByName(name);
	}
	public void saveOrUpdateCategory(Category category) {
		 categoryDao.saveOrUpdateCategory(category);
		
	}
	public void deleteCategory(int cid) {
		categoryDao.deletecategory(cid);
		
	}
	public Category getCategoryBycid(int cid) {
		
		return categoryDao.getcategoryBycid(cid);
	}

}
