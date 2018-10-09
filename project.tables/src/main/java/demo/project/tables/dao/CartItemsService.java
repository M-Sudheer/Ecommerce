package demo.project.tables.dao;

import java.util.List;

import demo.project.tables.model.CartItems;

public interface CartItemsService {
	public boolean addCartItem(CartItems cartItems);

	public boolean deleteCartItem(CartItems cartItems);

	public boolean updateCartItem(CartItems cartItems);

	public List<CartItems> getAllCartItemsByCartId(int cart_id);

	public CartItems getCartItemByCartId(int cart_id);

	public boolean deleteAllCartItems(int cart_id);
	
	public CartItems getCartItemId(int cartItem_id);
}
