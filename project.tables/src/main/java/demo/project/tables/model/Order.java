/*package demo.project.tables.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Order 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderNo;
	private Date date;
	private Timestamp timeStamp;
	private int cartId;
	private int noOfItems;
	private int netPrice;
	@OneToMany(mappedBy="cart",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<CartItem> cartItem;
	@OneToOne
	private Customer customer;
	
	
	
	
	
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	public int getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(int netPrice) {
		this.netPrice = netPrice;
	}
	public List<CartItem> getCartItem() {
		return cartItem;
	}
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}*/