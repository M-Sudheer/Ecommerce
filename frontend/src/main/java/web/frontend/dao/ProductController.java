
package web.frontend.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import demo.project.tables.model.SubCategory;
import demo.project.tables.model.Vendor;
import demo.project.tables.products.Laptop;
import demo.project.tables.productsDao.LaptopService;

@Controller
public class ProductController 
{

	@Autowired
	private SubCategory subCategory;
	
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
	
	@PostMapping("subcategory")
	public String getSubCategory(@RequestParam("category")int c_id, Model model) {
		 
		model.addAttribute("subCategoryList",subCategoryService.getSubCategoryList(c_id));
		return "subcategory";
	}
	
	

	@PostMapping("getModel")
	public String  addProducts(HttpServletRequest request,Model model,HttpSession session) {
		
	   
		SubCategory subCategory=subCategoryService.getSubCategory(Integer.parseInt(request.getParameter("subc_id")));
		model.addAttribute("subc_id",subCategory.getSubc_id());
		
		
		
	  switch(subCategory.getSubc_name())
		{
		  case "laptop": 
		  						
		  model.addAttribute("laptop" ,new Laptop());
		  					      
		  return "laptop";
		  
		 
		default: return "subcategory";
		}
	}
	
	@PostMapping("laptopprocess")
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
			return "vendorpage";
		}
		else
		{

		
		return "getModel";
	}	
	
	}
	
	@GetMapping("productdetails")
	public String getProducts(HttpSession session,Model model,Map<String,Object> products)
	{
		Vendor vendor=(Vendor)session.getAttribute("vendor");
		products.put("productList",productService.getAllProducts(vendor.getV_id()));
		
		return "productdetails";
	}
	
	
	@GetMapping("viewproductdetails/{product_id}")
	public String viewProducts(@PathVariable("product_id") int product_id, Model model)
	{
		String name = subCategoryService.getSubCategory(productService.getSubc_id(product_id)).getSubc_name();
		System.out.println(name);
		switch (name) 
		{
		case "laptop":
			model.addAttribute("laptop",laptopService.getLaptopDetails(product_id));
			return "laptopdetails";

		default:
			return "productdetails";
		}
	}
	
	
	
	@GetMapping("editproductdetails/{product_id}")
	public String editProducts(@PathVariable("product_id")int product_id,Model model,HttpServletRequest hServletRequest)
	{
		String name = subCategoryService.getSubCategory(productService.getSubc_id(product_id)).getSubc_name();
	
		switch (name) 
		{
		case "laptop":
			model.addAttribute("contextPath",hServletRequest.getContextPath());
			model.addAttribute("laptop", laptopService.getLaptopDetails(product_id));
			return "editlaptopdetails";

		default:
			return "productdetails";
		}
		
		
			
		}
		
		@PostMapping("editlaptopprocess")
		public String editLaptopDetails(@ModelAttribute("laptop")Laptop laptop,HttpServletRequest request)
		{
			if(!laptop.getImage().isEmpty())
			{
				ImageUpload.uploadImage(laptop, request);
			}
			
			laptopService.updateLaptop(laptop);
			return "vendorpage";
		}
		
		
	}
