/*package demo.project.tables.Imp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.AdminService;
import demo.project.tables.model.Admin;

@Component
@Transactional
public class AdminServiceImp implements AdminService
{
	private SessionFactory sessionFactory;

	@Override
	public boolean addAdmin(Admin admin) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(admin);
			
			return true;
			
		}
		catch (Exception e) 
		{
	
			return false;
			
		}
	}
	
	@Override
	public boolean updateAdmin(Admin admin) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(admin);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	
	@Override
	public boolean deleteAdmin(Admin admin) 
	{
		try
		{
		sessionFactory.getCurrentSession().delete(admin);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		}
	}
	*/