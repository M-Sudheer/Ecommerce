//VendorServiceImp
package demo.project.tables.Imp;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import demo.project.tables.dao.VendorService;
import demo.project.tables.model.Vendor;

@Component
@Transactional
public class VendorServiceImp implements VendorService
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addVendor(Vendor vendor)
	{
		try
		{
			sessionFactory.getCurrentSession().save(vendor);
			
			return true;
		}
		
		catch (Exception e) 
		{	
			return false;
		}
	}



	@Override
	public boolean deleteVendor(Vendor vendor) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(vendor);
			
			return true;
		}
		
		catch (Exception e) 
		{	
			return false;
		}

	}



	@Override
	public Vendor login(String email, String password) 
	{
		try
		{
    	Query<Vendor> query=sessionFactory.getCurrentSession().createQuery("from Vendor where email=:email and password=:password",Vendor.class);
        query.setParameter("email",email);
        query.setParameter("password",password);
        return query.getSingleResult();
	}
		catch (Exception e) 
		{
		return null;
		}
	}



	@Override
	public Vendor getVendor(int id) 
	{
		try
		{
			return sessionFactory.getCurrentSession().get(Vendor.class,id);
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	
	
	@Override
	public Vendor getVendorByEmail(String email) 
	{
		try
		{
		Query<Vendor> query=sessionFactory.getCurrentSession().createQuery("from Vendor where email=:email",Vendor.class);
		query.setParameter("email",email);
		return query.getSingleResult();
	}
	catch (Exception e) 
		{
		return null;
		}
	}



	@Override
	public boolean updateVendor(Vendor vendor) {
		try
		{
			sessionFactory.getCurrentSession().update(vendor);
			
			return true;
		}
		
		catch (Exception e) 
		{	
			return false;
		}
	}



	@Override
	public List<Vendor> getVendorDetails() 
	{
		try
		{
			Query<Vendor> query=sessionFactory.getCurrentSession().createQuery("from Vendor",Vendor.class);
			return query.getResultList();
		}
		catch (Exception e) {

		return null;
	}
	}
}
