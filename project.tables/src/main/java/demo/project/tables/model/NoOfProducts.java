package demo.project.tables.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class NoOfProducts
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemNo;
	private boolean sold;
	
	@ManyToOne
	private Products products;

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public Products getProduct() {
		return products;
	}

	public void setProduct(Products product) {
		this.products = product;
	}
	

}
