package demo.project.tables.productImp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.products.Mobile;
import demo.project.tables.productsDao.MobileService;

@Component
@Transactional
public class MobileServiceImp implements MobileService
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addMobile(Mobile mobile) {
		try {
			sessionFactory.getCurrentSession().save(mobile);
			return true;			
		} catch (Exception e) {
			
			return false;
		}
	}

	@Override
	public boolean updateMobile(Mobile mobile) {
		try {
			sessionFactory.getCurrentSession().update(mobile);
			return true;
		} 
		catch (Exception e) {
		
		return false;
	}
	}

	@Override
	public boolean deleteMobile(Mobile mobile) {
		try {
			sessionFactory.getCurrentSession().delete(mobile);
			return true;			
		} catch (Exception e) {
			
			return false;
		}
	}

	@Override
	public Mobile getMobileDetails(int product_id) {
		try {
			return sessionFactory.getCurrentSession().get(Mobile.class,product_id);
		} catch (Exception e) {
			return null;
		}
	}
	

}
