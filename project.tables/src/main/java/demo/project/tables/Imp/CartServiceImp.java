package demo.project.tables.Imp;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.hibernate.SessionFactory;
import demo.project.tables.dao.CartService;
import demo.project.tables.model.Cart;

@Transactional
@Component
public class CartServiceImp implements CartService
{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCart(Cart cart)
	{
		try
		{
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch (Exception e) 
		{	
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean deleteCart(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public Cart getCartById(int cartId) 
	{
		try
		{
				return sessionFactory.getCurrentSession().get(Cart.class,cartId);
		}
		catch (Exception e) 
		{
		return null;
	}	
}

}
