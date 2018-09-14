//ProductService
package demo.project.tables.dao;

import java.util.List;

import demo.project.tables.model.Products;

public interface ProductService
{
		public abstract boolean addProducts(Products products);
		public abstract boolean deleteProducts(Products products);
		
		public List<Products> getAllProducts(int v_id);
		
		public int getSubc_id(int product_id);
	

}
