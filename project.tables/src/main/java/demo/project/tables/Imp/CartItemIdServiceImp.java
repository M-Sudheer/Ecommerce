package demo.project.tables.Imp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.CartItemIdService;
import demo.project.tables.model.CartItemId;


@Component
@Transactional
public class CartItemIdServiceImp implements CartItemIdService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCartItemId(CartItemId cartItemId) {
		try {
			sessionFactory.getCurrentSession().save(cartItemId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCartItemId(CartItemId cartItemId) {
		try {
			sessionFactory.getCurrentSession().delete(cartItemId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCartItemId(CartItemId cartItemId) {
		try {
			sessionFactory.getCurrentSession().update(cartItemId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteAllCartItemId(int cartItem_id) {
		try {
			sessionFactory.getCurrentSession().createQuery("delete from CartItemId where cartItems_cartItem_id=:id")
					.setParameter("id", cartItem_id);
			return true;
		} catch (HibernateException e) {

			return false;
		}
	}

	@Override
	public List<CartItemId> getAllCartItemId(int cartItem_id) {

		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from CartItemId where cartItems_cartItem_id=:id", CartItemId.class)
					.setParameter("id", cartItem_id).getResultList();
		} catch (HibernateException e) {
			
			return null;
		}
	}
}