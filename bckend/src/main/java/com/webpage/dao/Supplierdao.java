package com.webpage.dao;

import java.util.List;

import com.webpage.model.Supplier;

public interface Supplierdao 
{

	public boolean addSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public Supplier getSupplier(int supplierId);
	public List<Supplier> listSuppliers();
}
