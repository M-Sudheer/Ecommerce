package demo.project.tables.dao;

import java.util.List;

import demo.project.tables.model.SubCategory;

public interface SubCategoryService 
{
	public abstract SubCategory getSubCategory(int subc_id);
	public List<SubCategory> getSubCategoryList(int c_id);
}
