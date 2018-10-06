package demo.project.tables.dao;

import java.util.List;

import demo.project.tables.model.CartItemId;

public interface CartItemIdService {

	public boolean addCartItemId(CartItemId cartItemId);

	public boolean deleteCartItemId(CartItemId cartItemId);

	public boolean updateCartItemId(CartItemId cartItemId);

	public boolean deleteAllCartItemId(int cartItem_id);

	public List<CartItemId> getAllCartItemId(int cartItem_id);
}
