package web.frontend.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.project.tables.dao.CategoryService;
import demo.project.tables.dao.ProductService;
import demo.project.tables.dao.SubCategoryService;
import demo.project.tables.dao.VendorService;
import demo.project.tables.model.NoOfProducts;
import demo.project.tables.model.Products;
import demo.project.tables.model.SubCategory;
import demo.project.tables.model.Vendor;
import demo.project.tables.products.Laptop;
import demo.project.tables.products.Mobile;
import demo.project.tables.productsDao.LaptopService;
import demo.project.tables.productsDao.MobileService;

@Controller
public class ProductController 
{

	
	@Autowired
	private Vendor vendor;
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private ImageUpload imageUpload;
	
	@Autowired
	private SubCategory subCategory;
	
	
	@Autowired
	private Mobile mobile;
	
	@Autowired
	private MobileService mobileService;
	
	@Autowired
	private Laptop laptop;
	
	@Autowired
	private LaptopService laptopService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/vendor/subcategory")
	public String getSubCategory(@RequestParam("category")int c_id, Model model) {
		 
		model.addAttribute("subCategoryList",subCategoryService.getSubCategoryList(c_id));
		return "subcategory";
	}
	
	

	@PostMapping("/vendor/getModel")
	public String  addProducts(HttpServletRequest request,Model model,HttpSession session) {
		
	   
		SubCategory subCategory=subCategoryService.getSubCategory(Integer.parseInt(request.getParameter("subc_id")));
		model.addAttribute("subc_id",subCategory.getSubc_id());
		
	  switch(subCategory.getSubc_name())
		{
		  case "laptop": 
		  						
		  model.addAttribute("laptop" ,new Laptop());
		  					      
		  return "laptop";
		  
		  case "Mobiles": 
				
			  model.addAttribute("mobile" ,new Mobile());
			  					      
			  return "mobile";
		  
		 
		default: return "subcategory";
		}
	}
	
	@PostMapping("/vendor/laptopprocess")
	public String addLaptop(@ModelAttribute("laptop") Laptop laptop,HttpSession httpSession,HttpServletRequest httpServletRequest)
	{
		
		
		System.out.println(laptop);
		
	   SubCategory subCategory=subCategoryService.getSubCategory(laptop.getSubCategory().getSubc_id());
	   Vendor vendor=(Vendor)httpSession.getAttribute("vendor");
		laptop.setVendor(vendor);
		laptop.setSubCategory(subCategory);
		
		if(laptopService.addLaptop(laptop))
		{
			String contextPath=httpServletRequest.getRealPath("/");
			File file=new File(contextPath+"/resources/images/products");
			System.out.println(file.getPath());
			if(!file.exists())
			{
				file.mkdir();
			}
			
			FileOutputStream fileOutputStream;
			
			try
			{
				fileOutputStream=new FileOutputStream(file.getPath()+"/"+laptop.getProduct_id()+".jpg");
				InputStream inputStream=laptop.getImage().getInputStream();
				byte[] imageBytes=new byte[inputStream.available()];
				inputStream.read(imageBytes);
				fileOutputStream.write(imageBytes);
				fileOutputStream.flush();
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			
			imageUpload.uploadImage(laptop, httpServletRequest);
			return "vendorpage";
		}
		else
		{

		
		return "getModel";
	}	
	
	}
	
	
	@PostMapping("/vendor/mobileprocess")
	public String addMobile(@ModelAttribute("mobile") Mobile mobile,HttpSession httpSession,HttpServletRequest httpServletRequest)
	{
		
		
		System.out.println(mobile);
		
	   SubCategory subCategory=subCategoryService.getSubCategory(laptop.getSubCategory().getSubc_id());
	   Vendor vendor=(Vendor)httpSession.getAttribute("vendor");
		mobile.setVendor(vendor);
		mobile.setSubCategory(subCategory);
		
		if(mobileService.addMobile(mobile))
		{
			
			imageUpload.uploadImage(mobile, httpServletRequest);
			return "vendorpage";
		}
		else
		{
		return "getModel";
	}	
	
	}
	
	
	@GetMapping("/vendor/productdetails")
	public String getProducts(HttpSession session,Model model,Map<String,Object> products,Principal principal)
	{
	/*	Vendor vendor=(Vendor)session.getAttribute("vendorDetails");*/
		Vendor vendor=vendorService.getVendorByEmail(principal.getName());
		System.out.println(productService.getAllProducts(vendor.getV_id()));
		products.put("productList",productService.getAllProducts(vendor.getV_id()));
		
		return "productdetails";
	}
	
	
	@GetMapping("/vendor/viewproductdetails/{product_id}")
	public String viewProducts(@PathVariable("product_id") int product_id, Model model)
	{
		String name = subCategoryService.getSubCategory(productService.getSubc_id(product_id)).getSubc_name();
		System.out.println(name);
		switch (name) 
		{
		case "laptop":
			model.addAttribute("laptop",laptopService.getLaptopDetails(product_id));
			return "laptopdetails";

		case "Mobiles":
			model.addAttribute("mobile",mobileService.getMobileDetails(product_id));
			return "mobiledetails";

		default:
			return "vendordetails";
		}
	}
	
	
	@GetMapping("/productspecifications/{product_id}")
	public String viewproductspecifications(@PathVariable("product_id") int product_id, Model model)
	{
		String name = subCategoryService.getSubCategory(productService.getSubc_id(product_id)).getSubc_name();
		System.out.println(name);
		switch (name) 
		{
		case "laptop":
			model.addAttribute("laptop",laptopService.getLaptopDetails(product_id));
			return "viewlaptop";

		case "Mobiles":
			model.addAttribute("mobile",mobileService.getMobileDetails(product_id));
			return "viewmobile";

		default:
			return "vendorpage";
		}
	}
	@GetMapping("/vendor/editproductdetails/{product_id}")
	public String editProducts(@PathVariable("product_id")int product_id,Model model,HttpServletRequest httpServletRequest)
	{
		String name = subCategoryService.getSubCategory(productService.getSubc_id(product_id)).getSubc_name();
	
		switch (name) 
		{
		case "laptop":
			model.addAttribute("contextPath",httpServletRequest.getContextPath());
			model.addAttribute("laptop", laptopService.getLaptopDetails(product_id));
			return "editlaptopdetails";
			
		case "Mobiles":
			model.addAttribute("contextPath",httpServletRequest.getContextPath());
			model.addAttribute("mobile",mobileService.getMobileDetails(product_id));
			return "editmobiledetails";
			
			
			

		default:
			return "productdetails";
		}
			
		}
		
		@PostMapping("editlaptopprocess")
		public String editLaptopDetails(@ModelAttribute("laptop")Laptop laptop,HttpServletRequest request)
		{
			if(!laptop.getImage().isEmpty())
			{
				imageUpload.uploadImage(laptop, request);
			}
			
			laptopService.updateLaptop(laptop);
			return "vendorpage";
		}
		
		

		@PostMapping("editmobileprocess")
		public String editMobileDetails(@ModelAttribute("mobile")Mobile mobile,HttpServletRequest request)
		{
			if(!mobile.getImage().isEmpty())
			{
				imageUpload.uploadImage(mobile, request);
			}
			
			mobileService.updateMobile(mobile);
			return "vendorpage";
		}
		
	@GetMapping("products/{subc_id}")
	public String getProducts(@PathVariable("subc_id") int subc_id,Map<String,Object> products,HttpSession httpSession)
	{
		httpSession.setAttribute("electronics", subCategoryService.getElectronics());
		products.put("productList", productService.getProducts(subc_id));
		return "productbar";
	}
	
	
	
	@GetMapping("/buyproducts/{product_id}")
	public String buyProducts(@PathVariable("product_id") int product_id, Model model)
	{
		String name = subCategoryService.getSubCategory(productService.getSubc_id(product_id)).getSubc_name();
		System.out.println(name);
		switch (name) 
		{
		case "laptop":
			model.addAttribute("laptop",laptopService.getLaptopDetails(product_id));
			return "buylaptop";

		case "Mobiles":
			model.addAttribute("mobile",mobileService.getMobileDetails(product_id));
			return "buymobile";

		default:
			return "vendorpage";
		}
	}

	
	
	}