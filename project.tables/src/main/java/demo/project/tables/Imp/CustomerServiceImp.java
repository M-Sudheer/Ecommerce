package demo.project.tables.Imp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
		catch (Exception e) 
		{
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

	@Override
	public Customer getCustomerByEmail(String email) 
	{
	try {
		Query<Customer> query=sessionFactory.getCurrentSession().createQuery("from Customer where email=:email", Customer.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	} catch (Exception e) {
		// TODO: handle exception
		return null;
	}	
		
	}

	@Override
	public Customer customerLogin(String email, String password) {
		try
		{
			Query<Customer> query=sessionFactory.getCurrentSession().createQuery("from Customer where email=:email and password=:password", Customer.class)
			.setParameter("email", email).setParameter("password",password);
			return query.getSingleResult();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		return null;
	}

}
}