package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.Services.CategoryService;
import com.niit.Services.ProductService;
import com.niit.Services.SupplierService;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController {
@Autowired
private ProductService productService;
@Autowired
private CategoryService categoryService;
@Autowired
private SupplierService supplierService;
	
@RequestMapping("/admin/product/productform")
public String getProductForm(Model model){
	model.addAttribute("product",new Product());
	model.addAttribute("category",new Category());
	model.addAttribute("supplier",new Supplier());
	List<Category> categoryDetails=categoryService.getAllCategories();
	model.addAttribute("categorydetails",categoryDetails);
	List<Supplier> supname=supplierService.getAllSuppliers();
	model.addAttribute("supplierdetails",supname);
	return "productform";
}

@RequestMapping("/admin/product/saveproduct")
public String saveProduct(  @ModelAttribute("product") Product p,HttpServletRequest request){
	
	Category category=categoryService.getByName(p.getCategory().getCategoryDetails());
	Supplier supplier=supplierService.getByName(p.getSupplier().getSupname());
	p.setCategory(category);
	p.setSupplier(supplier);
	
	productService.saveOrUpdateProduct(p);
	
	MultipartFile image=p.getImage();
	String rootDirectory=request.getSession().getServletContext().getRealPath("/");
	Path path=Paths.get(rootDirectory+"/WEB-INF/resources/images/"+p.getProductid()+".png");
	if(image!=null && !image.isEmpty()){
	try {
		image.transferTo(new File(path.toString()));
	} catch (IllegalStateException e) {
		e.printStackTrace();
		
	} catch (IOException e) {
		e.printStackTrace();
		
	}
}
	return "redirect:/all/product/productlist";
}

@RequestMapping("/all/product/productlist")
public String getAllProducts(Model model){
	List<Product> products=productService.getAllProducts();
	for(Product p:products){
		System.out.println(p.getName());
		System.out.println(p.getPrice());
	}
	model.addAttribute("products",products);
	return "productlist";
}

@RequestMapping("/all/product/viewproduct/{id}")
public String viewProduct(@PathVariable int id,Model model){
	Product product=productService.getProductById(id);
	model.addAttribute("product",product);
	return "viewproduct";
}

@RequestMapping("/all/product/editproduct/{id}")
public String editProduct(@PathVariable int id,Model model){
	Product product=productService.getProductById(id);
	model.addAttribute("product",product);
	List<Category> categoryDetails=categoryService.getAllCategories();
	model.addAttribute("categorydetails",categoryDetails);
	List<Supplier>sup_names=supplierService.getAllSuppliers();
	model.addAttribute("supplierdetails",sup_names);
	return "productform";
}

@RequestMapping("/admin/product/deleteproduct/{id}")
public String deleteProduct(@PathVariable int id){
	productService.deleteProduct(id);
	return "redirect:/all/product/productlist";
 }

@RequestMapping("/all/product/productByCategory")
public String getByCategory(@RequestParam(value="searchCondition")String searchCondition,Model model){
	
	List<Product> products=productService.getAllProducts();
	model.addAttribute("products", products);
	model.addAttribute("searchCondition",searchCondition);
	return "productlist";
  }


}