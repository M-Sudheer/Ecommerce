package demo.project.tables.dao;

import demo.project.tables.model.Cart;

public interface CartService 
{
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public Cart getCartById(int cartId);

}
