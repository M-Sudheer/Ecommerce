//AppTest
package demo.project.tables;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*import demo.project.tables.dao.AddressService;*/
/*import demo.project.tables.dao.AdminService;*/
import demo.project.tables.dao.CategoryService;
import demo.project.tables.dao.CustomerService;
import demo.project.tables.dao.SubCategoryService;
import demo.project.tables.dao.VendorService;
import demo.project.tables.model.Address;
import demo.project.tables.model.Admin;
import demo.project.tables.model.Cart;
import demo.project.tables.model.CartItem;
import demo.project.tables.model.CartItemId;
import demo.project.tables.model.Category;
import demo.project.tables.model.Customer;
import demo.project.tables.model.SubCategory;
import demo.project.tables.model.Vendor;
import demo.project.tables.products.Laptop;

@SpringJUnitConfig(classes={HibernateConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest
{
	
	@Autowired
	private Vendor vendor;
	@Autowired
	private Category category;
	@Autowired
	private SubCategory subCategory;
	@Autowired
	private Laptop laptop;
	
	@Autowired
	private Cart cart;
	@Autowired
	private CartItemId cartItemId;
	@Autowired
	private CartItem cartItem;
	@Autowired
	private Customer customer;
	@Autowired
	private Admin admin;

	
	
	@Autowired
	private VendorService vendorSevice;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SubCategoryService subCategoryService;
	/*@Autowired
	private LaptopService laptopService;*/
	/*@Autowired
	private CustomerService customerService;*/
	/*@Autowired
	private AdminService adminService;
	*/
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Before
	public  void setUp()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new  AnnotationConfigApplicationContext(HibernateConfig.class);
		
		vendor.setName("sahil");
		vendor.setEmail("sahil@gmail.com");
		vendor.setMobile("978989094");
		vendor.setPassword("sahil");
		vendor.setCompanyName("Amazon");
		vendor.getV_id();


		laptop.setRam("4gb");
		laptop.setRom("8gb");
		laptop.setPrice(50000);
		laptop.setProcessor("i5");
		laptop.setNoOfProducts(8);
		
		
		
		/*admin.setName("Sudheer");
		admin.setPassword("sudheer");*/
		
		
		/*customer.setName("kiran");
		customer.setEmail("kiran@gmail.com");
		customer.setPassword("kiran");
		*/
		
	}
	
	
	@Test
	public void addVendor()
	{
		assertEquals("Test user adding Failed",true,vendorSevice.addVendor(vendor));
		deleteVendor();
	}
	public void deleteVendor()
	{
		vendorSevice.deleteVendor(vendor);
	}
	
	
	
	/*@Test
	public void addCustomer()
	{
		assertEquals("test customer adding failed",true,customerService.addCustomer(customer));
		deleteCustomer();
	}
	
	public void deleteCustomer()
	{
		customerService.deleteCustomer(customer);
	}*/
	
	
	public void getVendorByEmail()
	{
		vendorSevice.addVendor(vendor);
		assertEquals("test by email failed",true,vendorSevice.getVendorByEmail(vendor.getEmail()));
	}

	public void getVendor()
    {
		vendorSevice.addVendor(vendor);
        assertEquals("test is failed",vendor,vendorSevice.getVendor(vendor.getV_id()));
    }
	
	/*@Test
	public void addLaptop()
	{
		subCategory=subCategoryService.getSubCategory(1);
		vendorSevice.addVendor(vendor);
		laptop.setSubCategory(subCategory);
		assertEquals("Test Insertion laptop failed",true,laptopService.addLaptop(laptop));
		deleteLaptop();
		deleteVendor();
	}
	
	private void deleteLaptop() 
	{
	laptopService.deleteLaptop(laptop);
	}*/
	
	/*@Test
	public void addAdmin()

	{
		assertEquals("Admin test failed",true,adminService.addAdmin(admin));
		deleteAdmin();
	}
	public void deleteAdmin()
	{
		adminService.deleteAdmin(admin);
	}*/
}
