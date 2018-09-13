package demo.project.tables.Imp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.NoOfProductsService;

@Component
@Transactional
public class NoOfProductsServiceImp implements NoOfProductsService
{
	
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addNoOfProducts(NoOfProductsService noOfProducts) 
	{
	  try 
		{
				sessionFactory.getCurrentSession().save(noOfProducts);
				return true;
		} 
	  catch(Exception e)
	  {
			return false;
	   }
		}
		
	}

	
