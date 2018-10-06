package web.frontend.dao;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import demo.project.tables.dao.CustomerService;
import demo.project.tables.model.Customer;
import demo.project.tables.model.CustomerLogin;
import demo.project.tables.products.Laptop;
import demo.project.tables.productsDao.LaptopService;

@Controller
public class CustomerController 
{
	@Autowired
	private CustomerLogin customerLogin;
	@Autowired
	private Customer customer;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private Laptop laptop;
	@Autowired
	private LaptopService laptopService;
	
	
@GetMapping("/customersignup")
public String customersignup(Model model)
{
	model.addAttribute("customer", new Customer());
	return "customersignup";
}

@PostMapping("/customerregister")
public String customersignup(@ModelAttribute("customer") Customer customer,Model model)
{
	if(customerService.getCustomerByEmail(customer.getEmail())==null)
	{
		customerService.addCustomer(customer);
		return "redirect:/customerlogin";
	}
	else
	{
		return "customersignup";
	}
}


@GetMapping("/customerlogin")
public String customerlogin(Model model)
{
	model.addAttribute("customerlogin", new Customer());
	return "customerlogin";
}

/*@PostMapping("customerloginprocess")
public String customerlogin(@ModelAttribute("customerlogin") CustomerLogin customerLogin,HttpSession httpSession)
{
	if(customerService.customerLogin(customerLogin.getEmail(), customerLogin.getPassword())!=null)
	{
		customer=customerService.customerLogin(customerLogin.getEmail(), customerLogin.getPassword());
		httpSession.setAttribute("customer", customer);
		return "customerpage";
	}
	else
	{
		return "customerlogin";
	}
}

*/

@GetMapping("customer/customerpage")
public ModelAndView CustomerIndex(Principal principal,HttpSession httpSession) {
	ModelAndView modelAndView = new ModelAndView("customerpage");
	Customer customer=customerService.getCustomerByEmail(principal.getName());
	httpSession.setAttribute("customerDetails", customer);
	return modelAndView;
}




@GetMapping("customer/customerprofile")
public String customerprofile()
{
    return "customerprofile";
}

@GetMapping("customer/editcustomer")
public String editcustomer(HttpSession httpSession,Model model)
{
    model.addAttribute("customer", httpSession.getAttribute("customerDetails"));
    return "editcustomer";
}

@PostMapping("customer/updatecustomer")
public String updatecustomer(@ModelAttribute("customer") Customer customer,HttpSession httpSession)
{
    httpSession.setAttribute("customerDetails", customer);
    customerService.updateCustomer(customer);
    return "customer/customerpage";
}

/*@GetMapping("customerlaptop")
public String laptop(HttpSession httpSession,Model model)
{
	model.addAttribute("laptop",httpSession.getAttribute("laptop"));
	return "customerlaptop";
}
*/
}
