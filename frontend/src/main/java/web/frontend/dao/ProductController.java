package web.frontend.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.project.tables.dao.CategoryService;
import demo.project.tables.dao.SubCategoryService;
import demo.project.tables.model.SubCategory;
import demo.project.tables.model.Vendor;
import demo.project.tables.products.Laptop;
import demo.project.tables.productsDao.LaptopService;

@Controller
public class ProductController {

	@Autowired
	private SubCategory subCategory;
	
	@Autowired
	private LaptopService laptopService;
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("subcategory")
	public String getSubCategory(@RequestParam("category")int c_id, Model model) {
		 
		model.addAttribute("subCategoryList",subCategoryService.getSubCategoryList(c_id));
		model.addAttribute("c_id",categoryService.getCategoryId(c_id));
		return "subcategory";
		
	}
	
	
	@PostMapping("getModel")
	public String  addProducts(HttpServletRequest request,Model model,HttpSession session) {
		
	   
		SubCategory subCategory=subCategoryService.getSubCategory(Integer.parseInt(request.getParameter("subc_id")));
		model.addAttribute("subc_id",subCategory.getSubc_id());
		
		Vendor vendor=(Vendor)session.getAttribute("vendor");
		model.addAttribute("v_id",vendor.getV_id());
		
	  switch(subCategory.getSubc_name())
		{
		  case "laptop": 
		  						
		  model.addAttribute("laptop" ,new Laptop());
		  					      
		  return "laptop";
		  
		 
		default: return "subcategory";
		}
	}
	
	@PostMapping("laptopprocess")
	public String addLaptop(@ModelAttribute("laptop") Laptop laptop)
	{
		laptopService.addLaptop(laptop);
		return "vendorpage";
	}	
	
}
