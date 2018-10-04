package demo.project.tables.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartItemId
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int cartItemId;
@OneToOne
private NoOfProducts noOfProducts;
@OneToOne
private CartItem cartItem;
public int getCartItemId() 
{
    return cartItemId;
}
public void setCartItemId(int cartItemId) {
    this.cartItemId = cartItemId;
}
public NoOfProducts getNoOfProducts() {
    return noOfProducts;
}
public void setNoOfProducts(NoOfProducts noOfProducts) {
    this.noOfProducts = noOfProducts;
}
public CartItem getCartItem() {
    return cartItem;
}
public void setCartItem(CartItem cartItem) {
    this.cartItem = cartItem;
}
}

