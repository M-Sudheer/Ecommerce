//ProductServiceImp
package demo.project.tables.Imp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.ProductService;

import demo.project.tables.model.Products;


@Component
@Transactional
public class ProductServiceImp implements ProductService
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private Products products;
	
	@Override
	public boolean addProducts(Products products) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(products);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public boolean deleteProducts(Products products) {
		try
		{
			sessionFactory.getCurrentSession().delete(products);
			return true;
		}
		catch (Exception e) 
		{
			return false;
		}
	}

	@Override
	public List<Products> getAllProducts(int v_id) 
	{
		
		try
		{
			Query<Products> query=sessionFactory.getCurrentSession().createQuery("from Products where vendor_v_id=:id",Products.class);
			
			query.setParameter("id", v_id);
			return query.getResultList();
		} 
		
	catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int getSubc_id(int product_id) 
	{
		try
		{
			Query<Products> query=sessionFactory.getCurrentSession().createQuery("from Products where product_id=:id",Products.class);
			query.setParameter("id",product_id);
			Products products=query.getSingleResult();
			return products.getSubCategory().getSubc_id();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return 0;
			// TODO: handle exception
		}		
		
	}
}
