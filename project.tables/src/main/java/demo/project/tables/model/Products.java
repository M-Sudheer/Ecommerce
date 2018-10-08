//Products
package demo.project.tables.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Component("products")
public class Products
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int product_id;
	private int noOfProducts;
	private int price;
	@Transient
	private MultipartFile image;

	
	@OneToMany(mappedBy="products",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<NoOfProducts> noOfProduct;
	
	
	/*@ManyToOne(fetch = FetchType.LAZY)
    private Vendor */
	
	public List<NoOfProducts> getNoOfProduct() {
		return noOfProduct;
	}
	public void setNoOfProduct(List<NoOfProducts> noOfProduct) {
		this.noOfProduct = noOfProduct;
	}
	@ManyToOne
	private Vendor vendor;
	
	@ManyToOne
	private SubCategory subCategory;
	
	
	
	public int getNoOfProducts() {
		return noOfProducts;
	}
	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) 
	{
		this.subCategory = subCategory;
	}
	public int getProduct_id() 
	{
		return product_id;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


	public Vendor getVendor() 
	{
		return vendor;
	}
	public void setVendor(Vendor vendor) 
	{
		this.vendor = vendor;
	}

	public void setProduct_id(int product_id) 
	{
		this.product_id = product_id;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
	
	
}
