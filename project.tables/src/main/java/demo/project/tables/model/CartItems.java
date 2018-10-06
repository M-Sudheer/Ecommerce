

package demo.project.tables.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItem_id;
	private int unitPrice;
	private int quantity;
	private int totalPrice;

	@ManyToOne
	private Cart cart;
	@OneToMany(mappedBy = "cartItems",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<CartItemId> cartItemIds;

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public int getCartItem_id() {
		return cartItem_id;
	}

	public void setCartItem_id(int cartItem_id) {
		this.cartItem_id = cartItem_id;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<CartItemId> getCartItemIds() {
		return cartItemIds;
	}

	public void setCartItemIds(List<CartItemId> cartItemIds) {
		this.cartItemIds = cartItemIds;
	}

}
