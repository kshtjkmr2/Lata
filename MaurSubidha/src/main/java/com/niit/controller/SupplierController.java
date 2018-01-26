package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.niit.Services.SupplierService;
import com.niit.model.Supplier;

@Controller
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("admin/supplier/supplierform")
	public String getSupplierForm(Model model){
		model.addAttribute("supplier",new Supplier());
		return "supplierform";
	}
	@RequestMapping("admin/supplier/savesupplier")
	public String saveSupplier(@Valid@ModelAttribute("supplier") Supplier s,BindingResult result,HttpServletRequest request){
		if(result.hasErrors())
			return "/admin/supplier/supplierform";
		supplierService.saveOrUpdateSupplier(s);
		
		MultipartFile image=s.getImage();
		String rootDirectory=request.getSession().getServletContext().getRealPath("/");
		Path path=Paths.get(rootDirectory+"/WEB-INF/resources/images/"+s.getSupid()+".png");
		if(image!=null && !image.isEmpty()){
		try {
			image.transferTo(new File(path.toString()));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

		return "redirect:/admin/supplier/supplierlist";
		
	}
	@RequestMapping("/admin/supplier/supplierlist")
	public String getAllSupplier(Model model){
		List<Supplier>suppliers=supplierService.getAllSuppliers();
		for(Supplier s:suppliers){	
			System.out.println(s.getSupname());
		}
		model.addAttribute("supplier",suppliers);
		return "supplierlist";	
	}
	
	@RequestMapping("/admin/supplier/viewsupplier/{sup_Id}")
	public String viewSupplier(@PathVariable int sup_Id,Model model){
		Supplier suppliers=supplierService.getSupplierBySup_Id(sup_Id);
		model.addAttribute("supplier",suppliers);
		return "viewsupplier";
	}
	
	 @RequestMapping("/admin/supplier/deletesupplier/{sup_Id}")
	   public String deleteSupplier(@PathVariable int sup_Id){
	   	supplierService.deleteSupplier(sup_Id);
	   	return "redirect:/admin/supplier/supplierlist";
	    }
	 
	   @RequestMapping("/admin/supplier/editsupplier/{sup_Id}")
	   public String editSupplier(@PathVariable int sup_Id,Model model){
	   Supplier suppliers=supplierService.getSupplierBySup_Id(sup_Id);
	   	model.addAttribute("supplier",suppliers);
	   	return "supplierform";
	   }
}
