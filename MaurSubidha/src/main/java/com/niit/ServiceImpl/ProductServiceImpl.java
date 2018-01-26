package com.niit.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Services.ProductService;
import com.niit.dao.ProductDao;
import com.niit.model.Product;

@Service
	public class ProductServiceImpl implements ProductService{
	@Autowired	
	private ProductDao productDao;
		public void saveOrUpdateProduct(Product product) {
		   productDao.saveOrUpdateProduct(product);
			
		}
		public List<Product> getAllProducts() {
			
			return productDao.getAllproducts();
		}
		public Product getProductById(int id) {
			
			return productDao.getproductById(id);
		}
		public void deleteProduct(int id) {
			productDao.deletproduct(id);
			
		}
}
