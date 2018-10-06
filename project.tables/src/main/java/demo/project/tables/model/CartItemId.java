package demo.project.tables.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartItemId {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemId_id;
	@ManyToOne
	private CartItems cartItems;
	@OneToOne
	private NoOfProducts noOfProducts;

	public int getCartItemId_id() {
		return cartItemId_id;
	}

	public void setCartItemId_id(int cartItemId_id) {
		this.cartItemId_id = cartItemId_id;
	}

	public CartItems getCartItems() {
		return cartItems;
	}

	public void setCartItems(CartItems cartItems) {
		this.cartItems = cartItems;
	}

	public NoOfProducts getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(NoOfProducts noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

}
