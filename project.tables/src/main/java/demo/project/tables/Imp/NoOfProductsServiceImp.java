package demo.project.tables.Imp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.NoOfProductsService;
import demo.project.tables.model.NoOfProducts;

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

	@Override
	public List<NoOfProducts> getNoOfProducts(int product_id) {
		try {
			
			return sessionFactory.getCurrentSession().createQuery("from NoOfProducts where product_product_id=:id").setParameter("id", product_id).getResultList();
					
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public NoOfProducts  getNoOfProductsByNoOfproductsId(int item_no) {
		try {
			return (NoOfProducts) sessionFactory.getCurrentSession()
					.createQuery("from NoOfProducts where item_no=:id").setParameter("id", item_no)
					.getSingleResult();
		} catch (Exception e) {
			
			return null;
		}
	}

}
