package com.niit.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.Services.CategoryService;
import com.niit.model.Category;
@Controller
public class CategoryController {
 @Autowired
private CategoryService categoryService;
 
 @RequestMapping("admin/category/categoryform")
 public String getCategoryForm(Model model){
		model.addAttribute("category",new Category());
		return "categoryform";
 }
   @RequestMapping("admin/category/savecategory")
   public String saveCategory(@ModelAttribute("category") Category c){
	   categoryService.saveOrUpdateCategory(c);
	return "redirect:/admin/category/categorylist";
	   
   }
   @RequestMapping("/admin/category/categorylist")
   public String getAllCategory(Model model){
		List<Category>categories=categoryService.getAllCategories();
		for(Category c:categories){	
			System.out.println(c.getCategoryDetails());
		}
		model.addAttribute("categories",categories);
		return "categorylist";
	}
   @RequestMapping("/admin/category/deletecategory/{cid}")
   public String deleteCategory(@PathVariable int cid){
   	categoryService.deleteCategory(cid);
   	return "redirect:/admin/category/categorylist";
    }
   @RequestMapping("/admin/category/editcategory/{cid}")
   public String editCategory(@PathVariable int cid,Model model){
   Category categories=categoryService.getCategoryBycid(cid);
   	model.addAttribute("category",categories);
   	return "categoryform";
   }
}
