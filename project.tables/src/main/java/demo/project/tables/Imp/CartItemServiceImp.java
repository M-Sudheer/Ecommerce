package demo.project.tables.Imp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.CartItemService;
import demo.project.tables.model.CartItem;

@Component
@Transactional
public class CartItemServiceImp implements CartItemService
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean updateCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch (Exception e) {
		
		return false;
	}
	}

	@Override
	public boolean deleteCartItem(CartItem cartItem) 
	{
		try
		{
		sessionFactory.getCurrentSession().delete(cartItem);
		return true;
		}
		catch (Exception e) {
			
		return false;
	}
}

	@Override
	public CartItem getCartItemByCartId(int cartItemId)
	{
		try
		{
			Query<CartItem> query=sessionFactory.getCurrentSession().createQuery("from CartItem where Cart_cartId=:Id");
			return query.getSingleResult();
		}
		catch (Exception e) 
		{	
			return null;
		}
	}
}
