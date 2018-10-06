package demo.project.tables.Imp;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.project.tables.dao.CartService;
import demo.project.tables.model.Cart;



@Component
@Transactional
public class CartServiceImp implements CartService {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Cart getCart(int id) {
		try {
			return (Cart) sessionFactory.getCurrentSession().createQuery("from Cart where customer_id=:id")
					.setParameter("id",id).getSingleResult();
		} catch (Exception e) {
              e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		} catch (Exception e) {
			return false;
		}	}

}
