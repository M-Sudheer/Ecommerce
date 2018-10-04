package demo.project.tables.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartItem
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int cartItemId;
    private int quantity;
    private int unitPrice;
    private int totalPrice;
    @ManyToOne
    private Cart cart;
    @OneToOne
    private Products products;
    @OneToOne
    private CartItemId cartItemsId;
    
    
    public CartItemId getCartItemsId() {
        return cartItemsId;
    }
    public void setCartItemsId(CartItemId cartItemsId) {
        this.cartItemsId = cartItemsId;
    }
    public int getCartItemId() {
        return cartItemId;
    }
    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public Products getProducts() {
        return products;
    }
    public void setProducts(Products products) {
        this.products = products;
    }
    
    
}