package demo.project.tables.dao;

import demo.project.tables.model.Cart;
import demo.project.tables.model.CartItem;

public interface CartItemService 
{
	public boolean addCartItem(CartItem  cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public CartItem getCartItemByCartId(int cartItemId);
}
