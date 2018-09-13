package web.frontend.dao;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import demo.project.tables.dao.CategoryService;
import demo.project.tables.dao.VendorService;
import demo.project.tables.model.Category;
import demo.project.tables.model.Login;
import demo.project.tables.model.Vendor;

@Controller
public class IndexController {
	
	
	@Autowired
	private Vendor vendor;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private Category category;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping(value= {"/index"})
	public ModelAndView indexPage()
	{
		ModelAndView modelAndView=new ModelAndView("index");
	    return modelAndView;
	}
	
	@RequestMapping("/contact")
	public String  contactPage(Model model,HttpSession session)
	{
		session.setAttribute("name","Sudheer");
		model.addAttribute("date", new Date());
		return "contact";
	}
	@RequestMapping("/home")
	public  ModelAndView getDate()
	{
		ModelAndView modelAndView=new ModelAndView("home");
		modelAndView.addObject("date", new Date());
		return modelAndView;
	}
	

	
	@GetMapping(value= {"/","/signup"})
	public String signup(Model model)
	{
		model.addAttribute("vendor", new Vendor());
		return "signup";
	}
	@PostMapping("/signup")
	public String addVendor( @Valid @ModelAttribute("vendor")Vendor vendor,BindingResult result) 
	{
		if(!result.hasErrors())
		{
		if(vendorService.getVendorByEmail(vendor.getEmail())==null)
		{
			vendorService.addVendor(vendor);
			return "redirect:/login";
		}
		
		else
		{
			return "signup";
		}
		}
		else
		{
			return "signup";
		}
	}
	@GetMapping("/login")
	public String login(Model model)
	{
		model.addAttribute("login", new Login());
		return "login";
	}

	@PostMapping("/login")
	public String getCustomer(@ModelAttribute("login") Login login,Vendor vendor,HttpSession httpSession)
		{
		if((vendorService.login(login.getEmail(),login.getPassword())!=null))
		{
			vendor=vendorService.login(login.getEmail(),login.getPassword());
			httpSession.setAttribute("vendor",vendor);
			
			return "vendorpage";

		}
		else
		{
			return "login";
		}
		}
	
	

	@GetMapping("/profile")
	public String profile()
	{
	return "profile";
	}
	
	@GetMapping(value= {"/edit"})
	public String editProfile(HttpSession httpSession,Model model)
	{
		model.addAttribute("vendor", httpSession.getAttribute("vendor"));
		return "edit";
	}
	
	
	@PostMapping("/update")
	public String update(@ModelAttribute("vendor")Vendor vendor,HttpSession httpSession)
	{
		System.out.println(vendor);
		httpSession.setAttribute("vendor", vendor);
		vendorService.updateVendor(vendor);
		return "profile";
		
	}
	
	
	
	@GetMapping("vendor")
	public String getVendor(Map<String,Object> vendor)
	{
		vendor.put("vendorList", vendorService.getVendorDetails());
		return "vendor";
	}
	
	
	
/*	@GetMapping("profile")
	public String getVendor()
	{
		return "profile";
	}*/
	
	
	
	
	@GetMapping("accept/{v_id}")
	public String acceptVendor(@PathVariable("v_id")int v_id)
	{
		Vendor vendor=vendorService.getVendor(v_id);
		vendor.setStatus(true);
		vendorService.updateVendor(vendor);
		return "index";
	}
	
	
	@GetMapping("reject/{v_id}")
	public String rejectVendor(@PathVariable("v_id")int v_id)
	{
		Vendor vendor=vendorService.getVendor(v_id);
		vendor.setStatus(false);
		vendorService.updateVendor(vendor);
		return "index";
	}
	
	@GetMapping("category")
	public String getCategory(Map<String,Object> category)
	{
		category.put("categoryList", categoryService.getCategoryDetails());
		return "category";
	}
	

	
	
}
