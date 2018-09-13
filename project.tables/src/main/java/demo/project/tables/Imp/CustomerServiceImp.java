package demo.project.tables.Imp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.CustomerService;
import demo.project.tables.model.Customer;

@Component
@Transactional
public class CustomerServiceImp  implements CustomerService
 {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCustomer(Customer customer) 
	{
		
		try
		{
			sessionFactory.getCurrentSession().save(customer);
			return true;
		}
		catch (Exception e) {
			
		
		// TODO Auto-generated method stub
		return false;
	}
	}

	@Override
	public boolean updateCustomer(Customer customer) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(customer);
			return true;
			
		}
		catch (Exception e) {
		
		// TODO Auto-generated method stub
		return false;
	}
	}

	@Override
	public boolean deleteCustomer(Customer customer)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(customer);
			return true;
		}
		
		catch (Exception e) {
			
		
		// TODO Auto-generated method stub
		return false;
	}
	}

}
