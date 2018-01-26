package com.niit.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Services.SupplierService;
import com.niit.dao.SupplierDao;
import com.niit.model.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
 private SupplierDao supplierDao;
	public List<Supplier> getAllSuppliers() {
		
		return supplierDao.getAllSuppliers();
	}
	public Supplier getByName(String name) {
		
		return supplierDao.getByName(name);
	}
	public void saveOrUpdateSupplier(Supplier supplier) {
		supplierDao.saveOrUpdate(supplier);
		
	}
	public void deleteSupplier(int sup_Id) {
		
		supplierDao.deleteSupplier(sup_Id);
		
	}
	public Supplier getSupplierBySup_Id(int sup_Id) {
		
		return supplierDao.getSupplierBySup_Id(sup_Id);
	}

}
