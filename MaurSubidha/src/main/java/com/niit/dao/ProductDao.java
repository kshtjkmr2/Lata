package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {
	List<Product> getAllproducts();

	void saveOrUpdateProduct(Product product);

	Product getproductById(int id);

	void deletproduct(int id);
	
}
