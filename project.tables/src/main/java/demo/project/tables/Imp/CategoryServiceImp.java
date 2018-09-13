package demo.project.tables.Imp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.CategoryService;
import demo.project.tables.model.Category;


@Component
@Transactional
public class CategoryServiceImp implements CategoryService
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCategory(Category category)
	{
	try
	{
			sessionFactory.getCurrentSession().save("category");
			return false;
	}
	catch (Exception e) 
	{
		return false;
	}
}


	@Override
	public List<Category> getCategoryDetails() 
	{
		try
		{
		Query<Category> query=sessionFactory.getCurrentSession().createQuery("from Category",Category.class);
		return query.getResultList();
		}
		catch (Exception e)
		{
			return null;
		}
	}


	@Override
	public Category getCategoryId(int c_id) 
	{
		try
		{
			return sessionFactory.getCurrentSession().get(Category.class,c_id);
		} 
		catch (Exception e) 
		{
			return null;
		}
	}
}