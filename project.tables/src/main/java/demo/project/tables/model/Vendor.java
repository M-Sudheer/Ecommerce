package demo.project.tables.model;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Vendor
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int v_id;
	@Column(unique=true)
	/*@NotNull(message="name should not be null")
	@NotBlank(message="name should not be blank")*/
	private String name;
	/*@NotNull(message="email should not be null")
	@NotBlank(message="email should not be blank")
	@Pattern(regexp="/^([a-zA-Z]+)@([a-sA-Z0-9]+).([a-z])",message="Enter a proper email id format")*/
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String mobile;
	private String companyName;
	/*@NotNull(message="password should not be null")
	@NotBlank(message="password should not be blank")*/
	@Column(unique=true)
	private String password;
	
	private boolean status=false;
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) 
	{
		this.status = status;
	}

	@OneToMany(mappedBy="vendor")
	private Set<Products> products;

	
	

	public int getV_id() {
		return v_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public Set<Products> getProducts() 
	{
		return products;
	}

	public void setProducts(Set<Products> products)
	{
		this.products = products;
	}

	@Override
	public String toString() {
		return "Vendor [v_id=" + v_id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", companyName="
				+ companyName + ", password=" + password + ", products="
				+ products + "]";
	}



}
