package demo.project.tables.dao;

import java.util.List;

import demo.project.tables.model.NoOfProducts;

public interface NoOfProductsService 
{
	public  boolean addNoOfProducts(NoOfProductsService noOfProducts);
	public List<NoOfProducts> getNoOfProducts(int product_id);
	public NoOfProducts getNoOfProductsByNoOfproductsId(int  itemNo);
}
